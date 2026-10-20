class Solution {
    public int dayOfYear(String date) {
       int month = Integer.parseInt(date.substring(5,7));
       int year = Integer.parseInt(date.substring(0,4));
       int leap = ((year%4==0 && year%100!=0)|| year%400==0)?29:28;
       
       
       if(month == 1)return Integer.parseInt(date.substring(8,10));
       else if(month == 2) return 31+Integer.parseInt(date.substring(8,10));
       else if(month == 3) return 31+leap+Integer.parseInt(date.substring(8,10));
       else if(month == 4) return 62+leap+Integer.parseInt(date.substring(8,10));
       else if(month == 5) return 92+leap+Integer.parseInt(date.substring(8,10));
       else if(month == 6) return 123+leap+Integer.parseInt(date.substring(8,10));
       else if(month == 7) return 153+leap+Integer.parseInt(date.substring(8,10));
       else if(month == 8) return 184+leap+Integer.parseInt(date.substring(8,10));
       else if(month == 9) return 215+leap+Integer.parseInt(date.substring(8,10));
       else if(month == 10) return 245+leap+Integer.parseInt(date.substring(8,10));
       else if(month == 11) return 276+leap+Integer.parseInt(date.substring(8,10));
       else if(month == 12) return 306+leap+Integer.parseInt(date.substring(8,10));
       return -1;


       

    }
}