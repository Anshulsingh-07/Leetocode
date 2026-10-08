class Solution {
    public String removeOuterParentheses(String s) {
        int count =  0;
        String str = "";
        int st = 0;
        int end = 0;
        
        for(int i = 0;i<s.length();i++){
           char ch = s.charAt(i);
           if(ch=='(')count++;
           else if(ch==')'){
            count--;
           }
           if(count==1 && ch=='(')continue;
           if(count==0 && ch==')')continue;
           else{
                str+=ch;
           }
        }
        return str;
    }
}