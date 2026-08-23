class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        
        for(int i =  0;i<bills.length;i++){
           
           if(bills[i]==5){
             five++;
           }
           else if(bills[i]==10){
            ten++;
            if(five>0){
                five-=1;
            }
            else{
                return false;
            }
           }
           else{
           
            if(five>0 && ten>0){
                ten--;
                five-=1;
            }
            else if(five>2){
                five-=3;
            }
            else{
                return false;
            }
           }

        }
        return true;
    }
}