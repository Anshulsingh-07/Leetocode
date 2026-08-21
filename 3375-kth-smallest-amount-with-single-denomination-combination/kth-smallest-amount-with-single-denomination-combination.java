import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    // Helper class to store precomputed LCM and its inclusion-exclusion sign
    private static class Subset {
        long lcm;
        int sign;

        Subset(long lcm, int sign) {
            this.lcm = lcm;
            this.sign = sign;
        }
    }

    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        List<Subset> subsets = new ArrayList<>();

        // Generate all 2^n - 1 non-empty subsets
        for (int i = 1; i < (1 << n); i++) {
            long lcmVal = 1;
            int count = 0;
            boolean overflow = false;

            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    lcmVal = lcm(lcmVal, coins[j]);
                    count++;
                    // If LCM exceeds our max possible binary search upper bound, 
                    // it won't contribute to the count (m / lcmVal will be 0).
                    if (lcmVal > 50_000_000_000L) { 
                        overflow = true;
                        break;
                    }
                }
            }

            if (!overflow) {
                int sign = (count % 2 == 1) ? 1 : -1;
                subsets.add(new Subset(lcmVal, sign));
            }
        }

        // Find the minimum coin to establish the search space boundaries
        long minCoin = coins[0];
        for (int coin : coins) {
            if (coin < minCoin) {
                minCoin = coin;
            }
        }

        // Binary search range
        long low = minCoin;
        long high = minCoin * k;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (countMultiples(mid, subsets) >= k) {
                ans = mid;
                high = mid - 1; // Try to find a smaller valid amount
            } else {
                low = mid + 1;  // Increase the amount limit
            }
        }

        return ans;
    }

    // Helper function to count unique multiples <= M using precomputed subsets
    private long countMultiples(long m, List<Subset> subsets) {
        long total = 0;
        for (Subset subset : subsets) {
            total += subset.sign * (m / subset.lcm);
        }
        return total;
    }

    // GCD function using Euclidean algorithm
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // LCM function utilizing the GCD function
    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}
