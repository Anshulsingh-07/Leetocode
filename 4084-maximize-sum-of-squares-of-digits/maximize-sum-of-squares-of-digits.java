class Solution {
    public String maxSumOfSquares(int n, int sum) {
        // 1. Boundary check
        if (sum < 0 || sum > 9 * n) {
            return "";
        }
        
        // 2. Compute exact distributions mathematically
        int numNine = sum / 9;
        int remainder = sum % 9;
        int numZeros = n - numNine - (remainder > 0 ? 1 : 0);
        
        StringBuilder sb = new StringBuilder(n); // Pre-allocate memory capacity
        
        // 3. Append blocks directly
        for (int i = 0; i < numNine; i++) {
            sb.append('9');
        }
        if (remainder > 0) {
            sb.append(remainder);
        }
        for (int i = 0; i < numZeros; i++) {
            sb.append('0');
        }
        
        return sb.toString();
    }
}
