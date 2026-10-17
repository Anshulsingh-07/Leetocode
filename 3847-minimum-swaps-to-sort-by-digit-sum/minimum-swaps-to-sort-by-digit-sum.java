class Solution {
    public static class Triplet implements Comparable<Triplet>{
        int s;
        int ind;
        int num;
        Triplet(int s, int ind,int num){
            this.s = s;
            this.ind = ind;
            this.num = num;
        }
        
        public int compareTo(Triplet p){

            if(this.s == p.s)return this.num-p.num;
            return this.s-p.s;
        }
    }
    public int minSwaps(int[] nums) {
        Triplet arr[] = new Triplet[nums.length];
        for(int i = 0;i<nums.length;i++){
            int num = nums[i];
            int sum = 0;
            while(num>0){
                sum+=num%10;
                num/=10;
            }
            arr[i] = new Triplet(sum,i,nums[i]);
           

        }
        
        Arrays.sort(arr);
        boolean vis[] = new boolean[nums.length];
        int swaps = 0;
        for(int i = 0;i<nums.length;i++){
            if(vis[i] || arr[i].ind == i){
                continue;
            }

            int size = 0;
            int j = i;
            while(!vis[j]){
                vis[j] = true;
                 j = arr[j].ind;
                 size++;
            }
            if(size>0){
                swaps+=size-1;
            }
        }
        return swaps;
        
        
        

    


    }
}