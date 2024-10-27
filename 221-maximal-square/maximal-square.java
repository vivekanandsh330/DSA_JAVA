class Solution {
    int dp[][];
    int solve(int i,int j,char matrix[][]){
        int n=matrix.length;
        int m=matrix[0].length;
        if(i>=n|| j>=m || matrix[i][j] == '0'){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int right=solve(i,j+1,matrix);
        int digonal=solve(i+1,j+1,matrix);
        int left=solve(i+1,j,matrix);
        return dp[i][j]=1+Math.min(right,Math.min(digonal,left));
    }
    public int maximalSquare(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        dp=new int[n+1][m+1];
        for(int el[]:dp){
            Arrays.fill(el,-1);
        }
        int currmax=0;
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    currmax=solve(i,j,matrix);
                    max=Math.max(max,currmax);
                }
            }
        }
        return max*max;
    }
}