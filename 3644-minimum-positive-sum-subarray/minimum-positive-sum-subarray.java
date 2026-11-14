class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<nums.size();i++){
            int sum = 0;
            for(int j = i;j<nums.size();j++){
                sum+=nums.get(j);
                if(j-i+1<=r && j-i+1>=l&& sum>0){
                    
                    min = Math.min(min,sum);
                }
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}