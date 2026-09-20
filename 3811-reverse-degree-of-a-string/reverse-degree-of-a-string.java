class Solution {
    public int reverseDegree(String s) {
       int result = 0;
       for(int i = 0;i<s.length();i++){
         result+=(('z'-s.charAt(i))+1)*(i+1);
       }
       return result;
    }
}