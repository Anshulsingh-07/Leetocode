class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1); // Base index for the first valid substring
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '(') {
                st.push(i); // Push index of '('
            } else {
                st.pop(); // Pop the matching '(' or the base index
                
                if (st.isEmpty()) {
                    st.push(i); // If stack is empty, use current index as new base
                } else {
                    maxLen = Math.max(maxLen, i - st.peek()); // Calculate length
                }
            }
        }
        return maxLen;
    }
}
