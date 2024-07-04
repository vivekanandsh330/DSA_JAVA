class Solution {
    int dp[];
    int solve(int n){

        if(n<0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }

        int in=solve(n-1);
        int ex=solve(n-2);
        return dp[n]=in+ex;
    }
    public int climbStairs(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n);
    }
}