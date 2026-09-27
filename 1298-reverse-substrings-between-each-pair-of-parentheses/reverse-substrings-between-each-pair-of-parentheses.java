class Solution {
  
    public String reverseParentheses(String s) {
        Stack<Character>st = new Stack<>();
       
        StringBuilder sb = new StringBuilder();
        
            for(int i = 0;i<s.length();i++){
                if(s.charAt(i)!=')'){
                     st.push(s.charAt(i));
                }
               
                else if(s.charAt(i)==')'){
                     String str = "";
                    while(st.peek()!='('){
                        str = str+st.peek();
                        st.pop();
                    }
                    st.pop();
                    for(int j = 0;j<str.length();j++){
                        st.push(str.charAt(j));
                    }
                }
                   
                
            }
            
           while(st.size()>0){
                sb.append(st.peek());
                st.pop();
            }
        
      
        
        return sb.reverse().toString();
    }
}