class Solution {
    public int[] maxDepthAfterSplit(String s) {
      
        int depth = 0;
    
        int i = 0;
        int ans[] = new int[s.length()];
        while(i<s.length()){
            if(s.charAt(i)=='('){
                depth++;
                ans[i] = depth%2==0?1:0;
            }
            else{
                ans[i] = depth%2==0?1:0;
                depth--;
            }
        
            i++;
        }
        return ans;
    }
}