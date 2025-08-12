package Greedy_Algorithm;
import java.util.*;

public class N_Meet_in_one_Room {
    public class meeting{
        int start;
        int end;
        int pos;
        meeting(int s, int e, int p){
            this.start = s;
            this.end = e;
            this.pos = p;
        }
    }

    public class Comparator implements java.util.Comparator<meeting>{
        @Override
        public int compare(meeting o1, meeting o2) {
            if(o1.end < o2.end){
                return -1;
            }else if (o1.end > o2.end){
                return 1;
            }else if (o1.pos < o2.pos){
                return -1;
            }
            return 0;
        }
    }

    public ArrayList<Integer> maxMeetings(int start[], int end[], int n) {
        ArrayList<meeting> meet = new ArrayList<>();
        for(int i=0;i<n;i++){
            meet.add(new meeting(start[i],end[i],i+1));
        }
        Collections.sort(meet, new Comparator());
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(meet.get(0).pos);
        int limit = meet.get(0).end;
        for(int i=1;i<n;i++){
            if(meet.get(i).start > limit){
                ans.add(meet.get(i).pos);
                limit = meet.get(i).end;
            }
        }
        return ans;

    }
}
