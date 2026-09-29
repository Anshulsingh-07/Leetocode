class Solution {
    int dp[][][] = new int[101][101][201];
    int solve(int i, int j , int count ,char [][]grid ){
        count += grid[i][j]=='('?1:-1;
        
        if(count<0 || count>200)return 0;
        if(dp[i][j][count]!=-1){
            return dp[i][j][count];
        }
        if(i == grid.length-1 && j == grid[0].length-1 && count==0)return dp[i][j][count] = 1;
            
        
        if(i<grid.length-1){
            if(solve(i+1,j,count,grid)==1)return dp[i][j][count] =  1;
        }
        if(j<grid[0].length-1){
            if(solve(i,j+1,count,grid)==1)return dp[i][j][count] =  1;
        }
        return dp[i][j][count] =  0;
    }
   
    
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n  = grid[0].length;
        if((m+n-1)%2!=0)return false;
        for(int i = 0;i<101;i++){
            for(int j = 0;j<101;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        if(grid[0][0]==')' || grid[m-1][n-1]=='(')return false;
        return solve(0,0,0,grid)==1;
        
        
    }
}