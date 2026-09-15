public class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int count = 0;
        int lastEnd = 0;

        // Start from the first index where a palindrome of length k can end
        for (int i = k - 1; i < n; i++) {
            // 1. Check for a palindrome of length k ending at i
            if (i - k + 1 >= lastEnd && isPalindrome(s, i - k + 1, i)) {
                count++;
                lastEnd = i + 1;
            } 
            // 2. Check for a palindrome of length k + 1 ending at i
            else if (i - k >= lastEnd && isPalindrome(s, i - k, i)) {
                count++;
                lastEnd = i + 1;
            }
        }

        return count;
    }

    // Helper method to check if the substring s[left...right] is a palindrome
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        
        // Example 1
        System.out.println(solver.maxPalindromes("abaccdbbd", 3)); // Output: 2
        
        // Example 2
        System.out.println(solver.maxPalindromes("adbcda", 2));    // Output: 0
    }
}
