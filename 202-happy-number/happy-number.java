class Solution {
    int sum(int n){
        int sum = 0;
        while(n>0){
        int dig = n%10;
        sum+=(int)Math.pow(dig,2);
        n = n/10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int sum = 0;
        HashSet<Integer>set = new HashSet<>();
        while(sum(n)!=1){
            
            if(set.contains(sum(n)) && sum(n)!=1)return false;
            set.add(sum(n));
             n = sum(n);
            
        }
        return true;
    }
}