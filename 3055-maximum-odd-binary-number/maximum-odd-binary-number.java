class Solution {
    public String maximumOddBinaryNumber(String s) {
        int onesCount = 0;
        int zerosCount = 0;
        
        // Count the occurrences of '1' and '0'
        for (char c : s.toCharArray()) {
            if (c == '1') {
                onesCount++;
            } else {
                zerosCount++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        // Append (onesCount - 1) '1's to the front for maximum value
        for (int i = 0; i < onesCount - 1; i++) {
            sb.append('1');
        }
        
        // Append all '0's in the middle
        for (int i = 0; i < zerosCount; i++) {
            sb.append('0');
        }
        
        // Append the last '1' at the end to guarantee it's odd
        sb.append('1');
        
        return sb.toString();
    }
}
