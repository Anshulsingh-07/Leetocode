class Solution {
    public int[] resultArray(int[] nums) {
        if(nums.length<2)return nums;
        
        List<Integer>list1 = new ArrayList<>();
         List<Integer>list2 = new ArrayList<>();
         if(nums.length>1){
         list1.add(nums[0]);
         list2.add(nums[1]);
         }
        for(int i = 2;i<nums.length;i++){
           
            if(list1.get(list1.size()-1)>list2.get(list2.size()-1)){
                list1.add(nums[i]);
                
            }
            
            else{
                list2.add(nums[i]);
            
            }
        }
        int m = 0;
        int arr[] = new int[list1.size()+list2.size()];
        for(int k = 0;k<list1.size();k++){
            arr[m++] = list1.get(k);
        }
        for(int k = 0;k<list2.size();k++){
            arr[m++] = list2.get(k);
        }
        return arr;
    }
}