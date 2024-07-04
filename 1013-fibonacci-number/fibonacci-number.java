class Solution {
    int []dp;
    int solve(int n){
        if(n==0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        
        int take = solve(n-1);
        int skip = solve(n-2);
        int ans=take+skip;
        return dp[n]=ans;
    }
    public int fib(int n) {
        dp=new int[n+1];
            Arrays.fill(dp,-1);
        
        return solve(n);
    }
}