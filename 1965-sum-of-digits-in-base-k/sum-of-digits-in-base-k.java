class Solution {
    public int sumBase(int n, int k) {
        int sum = 0;
        
        while (n > 0) {
            // Extract the remainder (digit in base k)
            sum += n % k;
            // Reduce n for the next iteration
            n /= k;
        }
        
        return sum;
    }
}
