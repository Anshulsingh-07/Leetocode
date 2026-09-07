class Solution {
    int MOD = 1000000007;
    public int distinctSubseqII(String s) {
        int n = s.length();
        long dp [] = new long[n+1];
        int last[] = new int[26];
        dp[0] = 1;
        Arrays.fill(last,-1);
        for(int i = 1;i<=n;i++){
            int ch = s.charAt(i-1)-'a';
            dp[i] = (2*dp[i-1])%MOD;
            if(last[ch]!=-1){
                dp[i] = (dp[i]-dp[last[ch]-1]+MOD)%MOD;
            }
            last[ch] = i;
        }
        return (int)(dp[n]-1+MOD)%MOD;
        
        
    }
}