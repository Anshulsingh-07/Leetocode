class Solution {
    String lexi(String a, String b){
        int i = 0;
        int j = 0;
        if(a.length()<b.length())return a;
         if(a.length()>b.length())return b;

        while(i<a.length() && j<b.length()){
            if(a.charAt(i) == '0' && b.charAt(j)=='1')return a;
            if(a.charAt(i) == '1' && b.charAt(j)=='0')return b;
            i++;
            j++;
        }
        return a;
    }
    public String shortestBeautifulSubstring(String s, int k) {
       
        
        String minSubString = "";
        for(int i = 0;i<s.length();i++){
            int count = 0;
            for(int j = i;j<s.length();j++){
                if(s.charAt(j)=='1')count++;
                if(count==k){
                    String currentSubString = s.substring(i,j+1);
                    if(minSubString.equals(""))minSubString = currentSubString;
                    minSubString = lexi(minSubString,currentSubString);
                    
                }
            }
        }
        return minSubString;
    }
}