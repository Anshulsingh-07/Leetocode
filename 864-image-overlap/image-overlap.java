class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
      int n = img1.length;
        int ans = 0;
        for(int i = -(n-1);i<=n-1;i++){
            for(int j = -(n-1);j<=n-1;j++){
                int count = 0;
                for(int a = 0;a<n;a++){
                    for(int b = 0;b<n;b++){
                        if(img1[a][b]==1){

                            int newrow = a+i;
                            int newcol = b+j;
                            if(newrow>=0 && newcol>=0 && newrow<n && newcol<n && img2[newrow][newcol]==1){
                                count++;
                            }
                        }
                    }
                }
                ans = Math.max(ans,count);
            }
        }
        return ans;
    }
}