class Solution {
    public boolean uniformArray(int[] nums) {
        
   int odd = 0;
   int even = 0;
   int min = Integer.MAX_VALUE;
   for(int i = 0;i<nums.length;i++){
    if(nums[i]%2==0)even++;
    else{
        odd++;
    }
    min = Math.min(min,nums[i]);
   }
   if(min%2==1)return true;
   else if(min%2==0 && even == nums.length)return true;
   return false;
    
    }
}