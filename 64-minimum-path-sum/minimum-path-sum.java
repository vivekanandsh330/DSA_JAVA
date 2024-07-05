class Solution {
    int [][]dp;
    int minPS(int [][] grid,int i,int j,int n,int m){
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(i == n-1 && j== m-1){
            return  grid[i][j];
        }
        if(i == n-1){
            return dp[i][j]= grid[i][j] + minPS(grid,i,j+1,n,m);
        }
        if(j == m-1){
            return dp[i][j]=grid[i][j] + minPS(grid,i+1,j,n,m);
        }
        else{
            return dp[i][j]=grid[i][j] + Math.min(minPS(grid,i,j+1,n,m),minPS(grid,i+1,j,n,m));
        }
    }
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        dp=new int[n+1][m+1];
        for(int []num : dp){
            Arrays.fill(num,-1);
        }
        
        return minPS(grid,0,0,n,m);
    }
}