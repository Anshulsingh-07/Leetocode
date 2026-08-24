class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int preSum[] = new int[n];
        preSum[0] = stones[0];
        for(int i = 1;i<stones.length;i++){
            preSum[i] = preSum[i-1]+stones[i];
        }
        int dp[] = new int[n];
        dp[n-1] = preSum[n-1];
        for(int i = n-2;i>=1;i--){
            int take = preSum[i]-dp[i+1];
            int skip = dp[i+1];
            dp[i] = Math.max(take, skip);

        }
        return dp[1];
    }
}