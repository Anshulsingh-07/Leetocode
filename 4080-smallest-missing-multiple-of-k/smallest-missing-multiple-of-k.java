class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer>set = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int i = 1;i<Integer.MAX_VALUE;i++){
            int num = k*i;
            if(!set.contains(num))return num;
        }
        return -1;
    }
}