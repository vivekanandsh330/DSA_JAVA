class Solution {
    int n;
    long dp[];
    long solve(int idx,int[][] questions){
        if(idx >= n){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        long take=questions[idx][0]+solve(idx+questions[idx][1]+1,questions);
        long nottake=(long)solve(idx+1,questions);
        return dp[idx]=Math.max(take,nottake);
    }
    public long mostPoints(int[][] questions) {
        n=questions.length;
        dp=new long[n+1];
        Arrays.fill(dp,-1);
        return solve(0,questions);
    }
}