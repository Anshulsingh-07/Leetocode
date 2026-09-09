class Solution {
    public long countCommas(long n) {
       long curr = 1000;
       long res = 0;
       while(curr<=n){
        res += n-curr+1;
        curr*=1000;

       }
       
         return res;
      
    }
}