class Solution {
    public int largestInteger(int[] nums, int k) {
        if(nums.length<k)return -1;
        HashMap<Integer,Integer>map = new HashMap<>();
       
        for(int i = 0;i<=nums.length-k;i++){
             HashSet<Integer>set = new HashSet<>();
            for(int j = i;j<k+i;j++){
            set.add(nums[j]);
            }
            for(int ele:set){
                map.put(ele,map.getOrDefault(ele,0)+1);
            }
        }
        int max = Integer.MIN_VALUE;
        int flag = 0;
        for(int i = 0;i<nums.length;i++){
           
            if(map.get(nums[i])==1){
                flag = 1;
                max = Math.max(max,nums[i]);
            }
        }
        for(int i= 0;i<nums.length;i++){
            System.out.println(map.get(nums[i]));
        } 

        return flag == 0?-1:max;
    }
}