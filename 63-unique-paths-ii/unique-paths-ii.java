class Solution {
   
    int solve(int i,int j,int a[][], int dp[][]){
        if(i>=0 && j>=0 && a[i][j] == 1){
            return 0;
        }
        if(i == 0 && j == 0){
            return 1;
        }
        if(i < 0 || j < 0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int up=solve(i-1,j,a,dp);
        int left=solve(i,j-1,a,dp);
        return dp[i][j]=up+left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int dp[][] =new int [n][m];
        for(int s[]: dp){
            Arrays.fill(s,-1);
        }
        return solve(n-1,m-1,obstacleGrid,dp);
        
    }
}