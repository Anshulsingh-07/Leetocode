class Solution {
    public int minOperations(int[] nums) {
        int ascCount = 0;
        int desCount = 0;
        int n = nums.length;
        for(int i = 1;i<nums.length;i++){
            ascCount += (nums[i] ==(nums[i-1]+1)%n)?1:0;
            desCount += (nums[i-1] ==(nums[i]+1)%n)?1:0;
        }

        if(ascCount == n-1 && nums[0] == 0)return 0;
        if(ascCount==n-1){
            int left = n-nums[0];
            int right = 1+nums[nums.length-1]+1+1;
            return Math.min(left,right);
        }
        else if(desCount == n-1){
            int left = n- nums[nums.length-1]+1;
            int right =  (nums[0]+1)%n+1;
            return Math.min(left,right);
        }
        return -1;
        
        
    }
}