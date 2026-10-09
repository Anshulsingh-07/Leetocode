class Solution {
    public int minInsertions(String s) {
        
        int count =  0;
        int ans = 0;
        int i = 0;

        while(i<s.length()){
            char ch = s.charAt(i);
            if(ch=='('){
                count++;
                i++;
            }
            else{
                if(count>0)count--;
                else{
                    ans++;
                }
                if(i<s.length()-1 && s.charAt(i+1)==')'){
                    
                    i+=2;
                }
                else{
                     ans+=1;
                     i++;
                }
                
            }
            
        }
        return ans+2*count;
            
        
    }
}