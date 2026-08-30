class Solution {
    public int minimumDeletions(int[] nums) {
        int minInd = 0;
        int maxInd = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]<min){
                min = Math.min(min,nums[i]);
                minInd = i;
            }
            if(nums[i]>max){
                max = Math.max(max,nums[i]);
                maxInd = i;
            }
        }
         System.out.println(minInd);
          System.out.println(maxInd);
        int a = nums.length-Math.max(minInd,maxInd);
        int b = Math.min(minInd,maxInd)+1;
        int c = a+b;
        System.out.println(c);
        int x = Math.min(minInd,maxInd)+Math.abs(maxInd-minInd)+1;
         System.out.println(x);
        int y = nums.length-Math.max(minInd,maxInd)+Math.abs(maxInd-minInd);
         System.out.println(y);
        return Math.min(c,Math.min(x,y));
    }
}