class Solution {
    int dp[][];
    int solve(int ca,int cp,int n){
        if(ca == n){
            return 0;
        }
        if(ca>n){
            return 1000;
        }
        if(dp[ca][cp] != -1){
            return dp[ca][cp] ;
        }
        int cap= 1+1+solve(ca+ca,ca,n);
        int p=1+solve(ca+cp,cp,n);
        return dp[ca][cp] = Math.min(cap,p);
    }

    public int minSteps(int n) {
        if(n == 1){
            return 0;
        }
        dp=new int[n+1][n+1];
        for(int []i: dp){
            Arrays.fill(i,-1);
        }
        return 1+solve(1,1,n);
    }
}