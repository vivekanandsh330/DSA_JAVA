class Solution {

    int minPS(int [][] grid,int i,int j,int n,int m, int [][]dp){
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(i == n-1 && j== m-1){
            return  grid[i][j];
        }
        if(i == n-1){
            return dp[i][j]= grid[i][j] + minPS(grid,i,j+1,n,m,dp);
        }
        if(j == m-1){
            return dp[i][j]=grid[i][j] + minPS(grid,i+1,j,n,m,dp);
        }
        else{
            return dp[i][j]=grid[i][j] + Math.min(minPS(grid,i,j+1,n,m,dp),minPS(grid,i+1,j,n,m,dp));
        }
    }
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int [][]dp=new int[n+1][m+1];
        for(int []num : dp) {
            Arrays.fill(num, -1);
        }
        return minPS(grid,0,0,n,m,dp);
    }
}