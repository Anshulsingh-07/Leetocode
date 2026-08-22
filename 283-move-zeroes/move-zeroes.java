class Solution {
    public void moveZeroes(int[] nums) {
        
        int i  = 0;
        int j = 0;
        for(int m = 0;m<nums.length;m++){
            if(nums[m]==0){
                i= m;
                j = m;
                break;
            }
        }
        while(j<nums.length && i<nums.length){
            if(nums[j]==0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp; 
                i++;
            }
            else{
                j++;
            }

            
        }
        
    }
}