class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int month[] = {0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        int stmonth1 = month[Integer.parseInt(arriveAlice.substring(0,2))];
        int stmonth2 = month[Integer.parseInt(arriveBob.substring(0,2))];
        int fimonth1 = month[Integer.parseInt(leaveAlice.substring(0,2))];
        int fimonth2 = month[Integer.parseInt(leaveBob.substring(0,2))];
        int stday1 = Integer.parseInt(arriveAlice.substring(3,5));
        int stday2 = Integer.parseInt(arriveBob.substring(3,5));
        int fiday1 = Integer.parseInt(leaveAlice.substring(3,5));
        int fiday2 = Integer.parseInt(leaveBob.substring(3,5));
        int st = Math.max(stmonth1+stday1,stmonth2+stday2);
        int fi = Math.min(fimonth1+fiday1,fimonth2+fiday2);
        
           

        return (st>fi)?0:Math.abs(fi-st)+1;

    }
}