#include <iostream>
#include <vector>
using namespace std;

class Process{
public:
    int pid; 
    int burst_time; 
    int arrival_time; 
    int waiting_time; 
    int turnaround_time; 
    int completion_time; 

    Process(int p, int bt, int at) : pid(p), burst_time(bt), arrival_time(at), waiting_time(0), turnaround_time(0), completion_time(0) {}
};

class FirstComeFirstServe {
public:
    void main(){
        int n;
        cout << "Enter the number of processes: ";
        cin >> n;
        vector<Process> processes;
        for (int i = 0; i < n; i++) {
            int bt, at;
            cout << "Enter burst time and arrival time for process " << i + 1 << ": ";
            cin >> bt >> at;
            processes.emplace_back(i + 1, bt, at);
        }

        calculateTimes(processes);
        printProcesses(processes);
    }

    void calculateTimes(vector<Process>& processes) {
        int n = processes.size();
        int current_time = 0;

        for (int i = 0; i < n; i++) {
            if (current_time < processes[i].arrival_time) {
                current_time = processes[i].arrival_time;
            }
            current_time += processes[i].burst_time;
            processes[i].completion_time = current_time;
            processes[i].turnaround_time = processes[i].completion_time - processes[i].arrival_time;
            processes[i].waiting_time = processes[i].turnaround_time - processes[i].burst_time;
        }
    }

    void printProcesses(const vector<Process>& processes) {
        cout<<"\n";

        cout << "Process details:\n";
        cout<<"------------------------------------------------\n";
        cout << "PID\tBT\tAT\tCT\tTAT\tWT\n";
        cout << "------------------------------------------------\n";
        for (const auto& p : processes) {
            cout << p.pid << "\t" << p.burst_time << "\t" << p.arrival_time << "\t" 
                 << p.completion_time << "\t" << p.turnaround_time << "\t" 
                 << p.waiting_time << "\n";
        }
        cout<<"------------------------------------------------";
        cout << "\n";
        double total_wt = 0, total_tat = 0;
        for (const auto& p : processes) {
            total_wt += p.waiting_time;
            total_tat += p.turnaround_time;
        }
        cout << "Average Waiting Time: " << total_wt / processes.size() << "\n";
        cout << "Average Turnaround Time: " << total_tat / processes.size() << "\n";
        cout << "Total Waiting Time: " << total_wt << "\n";
        cout << "Total Turnaround Time: " << total_tat << "\n";
        cout << "Total Processes: " << processes.size() << "\n";
        cout << "Total Burst Time: " << total_tat - total_wt << "\n";
        cout << "Total Completion Time: " << processes.back().completion_time << "\n";

    }
};

int main() {
    FirstComeFirstServe fcfs;
    fcfs.main();
    return 0;
}
