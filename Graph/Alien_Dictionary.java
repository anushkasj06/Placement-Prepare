import java.util.*;

public class Alien_Dictionary {

    public static String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<K; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<N-1; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(), s2.length());
            for(int ptr = 0; ptr<len; ptr++){
                if(s1.charAt(ptr) != s2.charAt(ptr)){
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }
        
        int[] inDegree = new int[K];
        for(int i=0; i<K; i++){
            for(int neighbor : adj.get(i)){
                inDegree[neighbor]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<K; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        
        String ans = "";
        while(!q.isEmpty()){
            int node = q.poll();
            ans = ans + (char)(node + 'a');
            
            for(int neighbor : adj.get(node)){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0){
                    q.add(neighbor);
                }
            }
        }
        
        return ans;
    }
}
