import java.util.Arrays;

class Solution {
    public long[] resultArray(int[] nums, int k) {
        // Global result array to store the counts for each remainder 0 to k-1
        long[] result = new long[k];
        
        // currentCounts[rem] stores the number of subarrays ending at the 
        // previous index that have a product modulo k equal to rem.
        long[] currentCounts = new long[k];
        
        for (int num : nums) {
            long[] nextCounts = new long[k];
            int val = num % k;
            
            // 1. Start a new subarray at the current element
            nextCounts[val]++;
            
            // 2. Extend all valid subarrays ending at the previous element
            for (int p = 0; p < k; p++) {
                if (currentCounts[p] > 0) {
                    int np = (int) (((long) p * val) % k);
                    nextCounts[np] += currentCounts[p];
                }
            }
            
            // 3. Update currentCounts for the next iteration
            currentCounts = nextCounts;
            
            // 4. Accumulate these ending subarrays into the global results
            for (int p = 0; p < k; p++) {
                result[p] += currentCounts[p];
            }
        }
        
        return result;
    }
}
