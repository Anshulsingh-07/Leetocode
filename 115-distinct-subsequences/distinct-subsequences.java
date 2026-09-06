class Solution {
    int solve(String a , String b, int i, int j,int[][]dp){
      
        if(j == b.length())return 1;

        if(i == a.length())return 0;
          if(dp[i][j]!=-1)return dp[i][j];
        
        if(a.charAt(i)== b.charAt(j)){
            return dp[i][j]  = solve(a,b,i+1,j+1,dp)+solve(a,b,i+1,j,dp);
        }
        return dp[i][j] = solve(a,b,i+1,j,dp);
       
    }
    public int numDistinct(String s, String t) {
        int dp[][] = new int[s.length()][t.length()];
        for(int i = 0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
      return solve(s,t,0,0,dp);
    }
}