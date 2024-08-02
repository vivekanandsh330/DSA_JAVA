class Solution {
    int dp[][];
    int solve(int i,int j,int[][] matrix){
        if(j<0 || j >=matrix[0].length){
            return (int)1e9;
        }
        if(i == 0){
            return matrix[0][j];
        }
        if(dp[i][j] != (int)1e9){
            return dp[i][j];
        }
        int ld=(int)1e9,rd=(int)1e9;
        int up=solve(i-1,j,matrix);
        if(j-1 >=0)
         ld=solve(i-1,j-1,matrix);
        if(j+1 < matrix[0].length)
        rd=solve(i-1,j+1,matrix);
        return dp[i][j]=matrix[i][j]+Math.min(up,Math.min(ld,rd));
    }
    public int minFallingPathSum(int[][] matrix) {
       int n=matrix.length;
       int m=matrix[0].length;
       dp=new int[n][m];
       for(int a[]: dp){
        Arrays.fill(a,(int)1e9);
       }
       int maxi=Integer.MAX_VALUE;
       for(int j=0;j<m;j++){
        int ans=solve(n-1,j,matrix);
        maxi=Math.min(maxi,ans);
       }
       return maxi;
    }

}