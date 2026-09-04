class Solution {
    public int firstStableIndex(int[] nums, int x) {
       
        int min_ind = nums.length;
      
        for(int i = 0;i<nums.length;i++){
             int min = Integer.MAX_VALUE;
             int max = Integer.MIN_VALUE;
           for(int j = i;j<nums.length;j++){
             min = Math.min(min,nums[j]);
            }
           for(int k = 0;k<=i;k++){
             max = Math.max(max,nums[k]);
           }
           System.out.println(min+","+max);
           if(max-min<=x){
           
            min_ind = Math.min(min_ind,i);
           }

        }

        
        return min_ind==nums.length?-1:min_ind;
    }
}