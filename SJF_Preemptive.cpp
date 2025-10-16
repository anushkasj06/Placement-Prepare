#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <climits>
using namespace std;

class Process {
public:
    int pid; 
    int burst_time; 
    int arrival_time; 
    int remaining_time; 
    int waiting_time; 
    int turnaround_time; 
    int completion_time; 

    Process(int p, int bt, int at) 
        : pid(p), burst_time(bt), arrival_time(at), remaining_time(bt), 
          waiting_time(0), turnaround_time(0), completion_time(0) {}

};

void calculateTimesbySJF(vector<Process>& processes);
void printProcesses(const vector<Process>& processes);
double calculateAverageWaitingTime(const vector<Process>& processes);
double calculateAverageTurnaroundTime(const vector<Process>& processes);
double calculateAverageResponseTime(const vector<Process>& processes);

int main(){
    int n;
    cout << "Enter the number of processes: ";
    cin >> n;

    vector<Process> processes;
    for (int i = 0; i < n; ++i) {
        int bt, at;
        cout << "Enter Burst Time and Arrival Time for Process " << i + 1 << ": ";
        cin >> bt >> at;
        processes.emplace_back(i + 1, bt, at);
    }

    sort(processes.begin(), processes.end(), [](const Process& a, const Process& b) {
        return a.arrival_time < b.arrival_time;
    });

    calculateTimesbySJF(processes);
    printProcesses(processes);



    return 0;
}

void calculateTimesbySJF(vector<Process>& processes) {
    int n = processes.size();
    int completed = 0, current_time = 0, min_index;
    vector<bool> is_completed(n, false);

    while (completed != n) {
        min_index = -1;
        int min_burst = INT_MAX;

        for (int i = 0; i < n; ++i) {
            if (processes[i].arrival_time <= current_time && !is_completed[i]) {
                if (processes[i].remaining_time < min_burst) {
                    min_burst = processes[i].remaining_time;
                    min_index = i;
                }
                if (processes[i].remaining_time == min_burst) {
                    if (processes[i].arrival_time < processes[min_index].arrival_time) {
                        min_index = i;
                    }
                }
            }
        }

        if (min_index == -1) {
            current_time++;
        } else {
            processes[min_index].remaining_time--;
            current_time++;

            if (processes[min_index].remaining_time == 0) {
                processes[min_index].completion_time = current_time;
                processes[min_index].turnaround_time = processes[min_index].completion_time - processes[min_index].arrival_time;
                processes[min_index].waiting_time = processes[min_index].turnaround_time - processes[min_index].burst_time;

                is_completed[min_index] = true;
                completed++;
            }
        }
    }
}

void printProcesses(const vector<Process>& processes) {
    cout << "Process ID\tBurst Time\tArrival Time\tCompletion Time\tTurnaround Time\tWaiting Time\n";
    for (const auto& p : processes) {
        cout << p.pid << "\t\t" << p.burst_time << "\t\t" << p.arrival_time << "\t\t"
             << p.completion_time << "\t\t" << p.turnaround_time << "\t\t" << p.waiting_time << "\n";
    }

    cout << "\n";
    cout << "Average Waiting Time: " << calculateAverageWaitingTime(processes) << "\n";
    cout << "Average Turnaround Time: " << calculateAverageTurnaroundTime(processes) << "\n";
    cout << "Average Response Time: " << calculateAverageResponseTime(processes) << "\n";

}

double calculateAverageWaitingTime(const vector<Process>& processes) {
    double total_wt = 0;
    for (const auto& p : processes) {
        total_wt += p.waiting_time;
    }
    return total_wt / processes.size();
}

double calculateAverageTurnaroundTime(const vector<Process>& processes) {
    double total_tat = 0;
    for (const auto& p : processes) {
        total_tat += p.turnaround_time;
    }
    return total_tat / processes.size();
}

double calculateAverageResponseTime(const vector<Process>& processes) {
    double total_rt = 0;
    for (const auto& p : processes) {
        total_rt += (p.turnaround_time - p.burst_time);
    }
    return total_rt / processes.size();
}
