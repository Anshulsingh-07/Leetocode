class Solution {
    
    public int scoreOfParentheses(String s) {
        
        Stack<Integer>st = new Stack<>();
        st.push(0);
        int count = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(0);
            }
            else if( s.charAt(i)==')'){
                int v = st.pop();
                count = st.pop();
                st.push(count+Math.max(2*v,1));
            }
        }
        return st.peek();
    }
}