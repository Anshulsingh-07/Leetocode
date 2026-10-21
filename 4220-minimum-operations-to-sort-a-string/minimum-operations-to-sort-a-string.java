class Solution {
    public int minOperations(String s) {
      
        boolean sorted = true;
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i-1)>s.charAt(i))sorted = false;
        }
        
        if(sorted)return 0;
        if(s.length()<=2)return -1;
        char min = s.charAt(0);
        char max = s.charAt(0);
        for(int i = 0;i<s.length();i++){
            min = (char)Math.min(min,s.charAt(i));
            max = (char)Math.max(max,s.charAt(i));
        }
        int mincount = 0;
        int maxcount = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)==min)mincount++;
            if(s.charAt(i)==max)maxcount++;
        }
        
        if(s.charAt(0)==min || s.charAt(s.length()-1)==max)return 1;
        else if(s.charAt(0)==max && s.charAt(s.length()-1)==min && mincount ==1  && maxcount ==1)return 3;
       
        return 2;

    }
}