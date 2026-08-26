class Solution {
    public int removeDuplicates(int[] nums) {
        int i =0;
        int j = i;
        int count = 1;
        while(i<nums.length && j<nums.length){
            int currentNum = nums[i];
            while(j<nums.length && nums[j]==currentNum){
                j++;
            }
            i++;
            if(j<nums.length){
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            j++;
            count++;
            }

            
        }
        return count;
        
    }
}