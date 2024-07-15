class Solution {
    int dp[][];
    int solve(int i,int j){
        if(i == 0 && j ==0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int up=solve(i-1,j);
        int left=solve(i,j-1);
        return dp[i][j]= up+left;
    }
    public int uniquePaths(int m, int n) {
        dp=new int[m+1][n+1];
        for(int a[]: dp){
           Arrays.fill(a,-1);
        }
        return solve(m-1,n-1);
        
    }
}