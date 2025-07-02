import java.util.LinkedList;
import java.util.Queue;
//         return false; // No cycle found

public class Neares_01_Matrix {
    class Node{
        int first;
        int second;
        int third;
        Node(int f, int s, int t){
            first = f;
            second= s;
            third = t;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<Node> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    vis[i][j]=1;
                    q.add(new Node(i,j,0));
                }else{
                    vis[i][j] =0;
                }
            }
        }

        int[] delr = {-1,0,1,0};
        int[] delc = {0,1,0,-1};
        while(!q.isEmpty()){
            int r =q.peek().first;
            int c = q.peek().second;
            int s = q.peek().third;
            q.poll();
            dist[r][c] = s;
            for(int i=0;i<4;i++){
                int nrow = r+delr[i];
                int ncol = c+ delc[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    q.add(new Node(nrow, ncol, s+1));
                }
            }
        }

        return dist;
    }
}
