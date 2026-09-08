class Solution {
    public int countCommas(int n) {
        if(n<1000)return 0;
        if(n == 100000)return 99001;
        
        return (n-1000)+1;
    }
}