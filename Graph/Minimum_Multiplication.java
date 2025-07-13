import java.util.*;

public class Minimum_Multiplication {
    static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static int minStep(int start, int end, int[] arr){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start,0));
        int[] dist = new int[100000];
        Arrays.fill(dist, (int)1e9);
        dist[start] = 0;
        int mod = 100000;
        while(!q.isEmpty()){
            Pair p = q.peek();
            q.remove();
            int node = p.first;
            int step = p.second;
            for(int it : arr){
                int num = (it*node)%mod;
                if(dist[num]>(step+1)){
                    dist[num] = step+1;
                    if(num==end){
                    return step+1;
                    }
                    q.add(new Pair(num, step+1));
                }
            }
        }
        return -1;
    }
}
