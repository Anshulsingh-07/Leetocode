class Solution {
    public int subsetXORSum(int[] nums) {
        int bitwiseOr = 0;
        for (int num : nums) {
            bitwiseOr |= num;
        }
        
        // Multiply by 2^(N-1) using the left shift operator
        return bitwiseOr << (nums.length - 1);
    }
}
