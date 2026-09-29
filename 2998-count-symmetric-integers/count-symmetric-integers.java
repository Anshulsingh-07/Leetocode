class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        
        for (int i = low; i <= high; i++) {
            if (isSymmetric(i)) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isSymmetric(int num) {
        String str = Integer.toString(num);
        int len = str.length();
        
        // Symmetric numbers must have an even number of digits
        if (len % 2 != 0) {
            return false;
        }
        
        int firstHalfSum = 0;
        int secondHalfSum = 0;
        int mid = len / 2;
        
        // Calculate the sum for both halves
        for (int i = 0; i < mid; i++) {
            firstHalfSum += str.charAt(i) - '0';
            secondHalfSum += str.charAt(mid + i) - '0';
        }
        
        return firstHalfSum == secondHalfSum;
    }
}
