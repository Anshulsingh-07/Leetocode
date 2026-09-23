class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        
        // Target sum for the middle elements we want to leave behind
        int target = totalSum - x; 
        
        if (target < 0) return -1;
        if (target == 0) return nums.length; 

        int left = 0, currentSum = 0, maxLen = -1;

        // Sliding window to find the longest subarray summing up to 'target'
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            // Shrink the window from the left if the sum is too large
            while (currentSum > target && left <= right) {
                currentSum -= nums[left];
                left++;
            }

            // If we find a valid window, track its maximum length
            if (currentSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        // Minimum operations = Total elements minus the maximum elements left in the middle
        return maxLen == -1 ? -1 : nums.length - maxLen;
    }
}
