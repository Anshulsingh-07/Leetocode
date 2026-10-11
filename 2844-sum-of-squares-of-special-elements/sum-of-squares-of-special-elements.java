class Solution {
    public int sumOfSquares(int[] nums) {
        int sum = nums[0]*nums[0];
        int n = nums.length;
        for(int i = 1;i<n;i++){
            if(n%(i+1)==0){
                sum+=(nums[i]*nums[i]);
            }
        }
        return sum;
        
    }
}