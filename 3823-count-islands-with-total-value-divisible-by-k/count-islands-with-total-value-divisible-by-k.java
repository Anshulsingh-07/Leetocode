class Solution {
   
    long dfs(int [][]grid,int i, int j, int m, int n,int[][]adj,boolean[][]vis){
        if(i<0 || j<0 || i>=m || j>=n || vis[i][j] || grid[i][j]==0)return 0;
        vis[i][j] = true;
        long sum = grid[i][j];
        for(int k = 0;k<4;k++){
           sum+= dfs(grid,i+adj[k][0],j+adj[k][1],m,n,adj,vis);
        }
        return sum;

    }
    public int countIslands(int[][] grid, int k) {
        int adj[][] = {{0,-1},{-1,0},{0,1},{1,0}};
        int m = grid.length;
        int n  = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        
        int count = 0;
        for(int i =0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(!vis[i][j] && grid[i][j]>0){
                
               
                if( dfs(grid,i,j,m,n,adj,vis)%k==0)count++;
                
            }
        }
        }
    return count;
    }
}