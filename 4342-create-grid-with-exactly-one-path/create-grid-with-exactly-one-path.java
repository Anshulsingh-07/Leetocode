class Solution {
    public String[] createGrid(int m, int n) {
        String str ="";
        String s = "";
        for(int i = 0;i<n-1;i++){
            str  = str+'.';
            s = s+'#';
        }
        String arr[] = new String[m];
        arr[0] = str+'.';
        for(int i = 1;i<m;i++){
            arr[i] = s+'.';
        }
        return arr;

    }
}