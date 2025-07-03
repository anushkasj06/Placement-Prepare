public class No_of_Enclaves {
     public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] delr = { -1,0,1,0};
        int[] delc = { 0 ,1,0, -1};

        int[][] vis = new int[n][m];
        for(int j=0;j<m;j++){
            if(vis[0][j]==0 && grid[0][j]==1){
                dfs(0,j,grid, vis, delr, delc);
            }
            if(vis[n-1][j]==0 && grid[n-1][j]==1){
                dfs(n-1,j, grid, vis, delr, delc);
            }
        }

        for(int i=0;i<n;i++){
            if(vis[i][0]==0 && grid[i][0]==1){
                dfs(i,0,grid, vis, delr, delc);
            }
            if(vis[i][m-1]==0 && grid[i][m-1]==1){
                dfs(i,m-1, grid, vis, delr, delc);
            }
        }

        int count =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(int r, int c, int[][] grid, int[][] vis, int[] delr, int[] delc){
        vis[r][c]=1;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<4;i++){
            int nrow = r+ delr[i];
            int ncol = c+ delc[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                dfs(nrow, ncol,grid, vis, delr, delc);
            }
        }
    }
}
