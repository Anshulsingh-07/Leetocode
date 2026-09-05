class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int maxPre[] = new int[nums.length];
        int minPre[] = new int[nums.length];
        int min = nums[nums.length-1   ];
        int max = nums[0];
        int min_ind = nums.length;
        for(int i = 0;i<nums.length;i++){
             min = Math.min(min,nums[nums.length-1-i ]);
             max = Math.max(max,nums[i]);
            minPre[nums.length-1-i] = min;
            maxPre[i] = max;
            
           
           
        }
        for(int i = 0;i<nums.length;i++){
            if(maxPre[i]-minPre[i]<=k){
                min_ind = Math.min(min_ind,i);
            }
        }
        return min_ind==nums.length?-1:min_ind;
    }
}