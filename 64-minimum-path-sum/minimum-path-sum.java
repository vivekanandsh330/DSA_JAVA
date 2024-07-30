class Solution {
    Integer dp[][];
    int solve(int[][] grid,int i,int j){
        if(i == 0 && j == 0){
            return grid[i][j];
        }
        if(i<0 || j<0 ){
            return (int)1e7;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        int up=grid[i][j]+solve(grid,i-1,j);
        int left=grid[i][j]+solve(grid,i,j-1);
        return  dp[i][j]=Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        dp=new Integer[n+1][m+1];
        return solve(grid,n-1,m-1);
    }
}