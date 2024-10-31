class Solution {
    int dp[][];
    int solve(String text1, String text2,int i,int j){
        int n=text1.length();
        int m=text2.length();
        if(i>=n || j>= m){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(text1.charAt(i) == text2.charAt(j)){
            return dp[i][j]=1+solve(text1,text2,i+1,j+1);
        }else{
            return dp[i][j]=Math.max(solve(text1,text2,i,j+1),solve(text1,text2,i+1,j));
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        dp=new int[n+1][m+1];
        for(int e[]:dp){
            Arrays.fill(e,-1);
        }
        return solve(text1,text2,0,0);
    }
}