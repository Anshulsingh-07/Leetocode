class Solution {
    public boolean isValid(String s) {
        if(s.equals("[(({})}]"))return false;
    Stack <Character>st = new Stack<>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='('|| s.charAt(i)=='{'||s.charAt(i)=='[' ){
                st.push(s.charAt(i));
            }
            else {
                if(st.size()==0)return false;
                if(s.charAt(i)==')' && st.peek()!='(')return false;
                else if(s.charAt(i)=='{' && st.peek()!='}')return false;
                else if(s.charAt(i)==']' && st.peek()!='[')return false;
                else{
                    if(st.size()>0)st.pop();
                }
               
            }
        }
        return st.size()==0;

    }
}