class Solution {
    Integer dp[][];
    int solve(List<List<Integer>> triangle,int i,int j,Integer dp[][]){
        int n=triangle.size();
        if(i == n-1){
            return triangle.get(n-1).get(j);
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        int down=triangle.get(i).get(j)+solve(triangle,i+1,j,dp);
        int digonal=triangle.get(i).get(j)+solve(triangle,i+1,j+1,dp);
        return dp[i][j]= Math.min(down,digonal);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        dp=new Integer[n][n];
        return solve(triangle,0,0,dp);
    }
}