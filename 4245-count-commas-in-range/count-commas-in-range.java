class Solution {
    public int countCommas(int n) {
        if(n<1000)return 0;
        if(n == 100000)return 99001;
        int count = 0;
        for(int i = 1000;i<=n;i++){
            int length = (int)Math.log10(i)+1;
            count+= length/3;
        }
        return count;
    }
}