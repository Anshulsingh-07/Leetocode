import java.util.Arrays;

class Solution {
    public int maxCoins(int[] piles) {
        // Sort the piles in ascending order
        Arrays.sort(piles);
        
        int totalCoins = 0;
        int n = piles.length / 3;
        
        // Start from the second to last element and step backward by 2
        // Stop once we reach Bob's territory (the first n elements)
        for (int i = piles.length - 2; i >= n; i -= 2) {
            totalCoins += piles[i];
        }
        
        return totalCoins;
    }
}
