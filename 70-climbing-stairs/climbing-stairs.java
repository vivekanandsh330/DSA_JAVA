class Solution {
    int memo[];
    int solve(int n){

        if(n<0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        if(memo[n] != -1){
            return memo[n];
        }

        int in=solve(n-1);
        int ex=solve(n-2);
        return memo[n]=in+ex;
    }
    public int climbStairs(int n) {
        memo=new int[n+1];
        Arrays.fill(memo,-1);
        return solve(n);
    }
}