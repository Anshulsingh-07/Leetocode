class Solution {
    public int sortPermutation(int[] nums) {
        boolean isSorted = true;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]<nums[i-1])isSorted =  false;
        }
        if(isSorted)return 0;
        int and  = 1;
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=i && count == 0){
                and = nums[i];
                count++;
            }
            else{
                if(nums[i]!=i){
                    and = and&nums[i];
                }
            }

        }

     return and;
    }

}