class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int totalDrunk = 0;
        int emptyBottles = 0;
        
        while (numBottles > 0 || emptyBottles >= numExchange) {
            // 1. Drink all the current full bottles
            if (numBottles > 0) {
                totalDrunk += numBottles;
                emptyBottles += numBottles;
                numBottles = 0; // All full bottles are now drunk
            }
            
            // 2. Exchange empty bottles for ONE full bottle if possible
            if (emptyBottles >= numExchange) {
                emptyBottles -= numExchange;
                numBottles += 1;
                numExchange += 1; // Increase exchange cost for the next time
            }
        }
        
        return totalDrunk;
    }
}
