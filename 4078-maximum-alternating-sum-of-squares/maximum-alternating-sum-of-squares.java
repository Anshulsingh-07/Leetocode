class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

       
        long sum = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]<0){
                nums[i] = -1*nums[i];
            }
        }
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++){
            if(i<n/2){
                sum-=(nums[i]*nums[i]);
            }
            else{
                sum+=(nums[i]*nums[i]);
            }
        }
    return sum;

    }
}