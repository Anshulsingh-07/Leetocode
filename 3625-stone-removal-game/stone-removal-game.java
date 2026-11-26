class Solution {
    public boolean canAliceWin(int n) {
        
        for(int i = 10;i>=0;i--){
            
            if(i%2==0 && n<i){
                return false;
            }
            else if(i%2!=0 && n<i){
                return true;
            }
            n = n-i;

        }
        return true;
      
    }

}