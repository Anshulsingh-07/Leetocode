class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    void dfs(int[][]grid,int i, int j,int m, int n,boolean[][]vis,int [][]adj){
        if(i<0 || j<0 || i>=m || j>=n || vis[i][j] || grid[i][j]==1)return ;
        vis[i][j] = true;
        for(int k = 0;k<4;k++){
           dfs(grid,i+adj[k][0],j+adj[k][1],m,n,vis,adj);
        }
    }
    public int closedIsland(int[][] grid) {
        int adj[][] = {{0,-1},{-1,0},{0,1},{1,0}};
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        Queue<Pair>q = new LinkedList<>();
        for(int i = 0;i<m;i++){
            if(grid[i][0]==0 && !vis[i][0]){
                q.add(new Pair(i,0));
                vis[i][0] = true;
            }
            if(grid[i][n-1]==0 && !vis[i][n-1]){
                q.add(new Pair(i,n-1));
                vis[i][n-1] = true;
            }
        }
        for(int j = 0;j<n;j++){
            if(grid[0][j]==0 && !vis[0][j]){
                q.add(new Pair(0,j));
                vis[0][j] = true;
            }
            if(grid[m-1][j]==0 && !vis[m-1][j]){
                q.add(new Pair(m-1,j));
                vis[m-1][j] = true;
            }
        }
        while(q.size()>0){
            Pair p = q.poll();
            for(int i = 0;i<4;i++){
                int row = p.r+adj[i][0];
                int col = p.c+adj[i][1];
                if(row>=0 && col>=0 && row<m && col<n && grid[row][col]==0 && !vis[row][col]){
                    q.add(new Pair(row,col));
                    vis[row][col] = true;
                }
            }
        }
        int count = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]==0 && !vis[i][j]){
                    dfs(grid,i,j,m,n,vis,adj);
                    count++;
                }
            }

        }
        return count;
    }
}