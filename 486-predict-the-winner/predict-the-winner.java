class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        // memo[i][j] stores the max score difference player 1 can achieve from subarray nums[i...j]
        Integer[][] memo = new Integer[n][n];
        return maxScoreDiff(nums, 0, n - 1, memo) >= 0;
    }

    private int maxScoreDiff(int[] nums, int i, int j, Integer[][] memo) {
        // Base case: only one element left
        if (i == j) {
            return nums[i];
        }
        
        // Return already calculated result to avoid redundant work
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        // Option 1: Player takes the left element (i)
        int pickLeft = nums[i] - maxScoreDiff(nums, i + 1, j, memo);
        
        // Option 2: Player takes the right element (j)
        int pickRight = nums[j] - maxScoreDiff(nums, i, j - 1, memo);

        // Store and return the optimal choice
        memo[i][j] = Math.max(pickLeft, pickRight);
        return memo[i][j];
    }
}
