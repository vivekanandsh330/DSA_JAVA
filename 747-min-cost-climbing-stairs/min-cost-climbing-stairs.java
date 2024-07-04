class Solution {
    int []dp;
    int minCost(int i,int []cost){
        int n=cost.length;
        if(i>=n){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int a= cost[i]+minCost(i+1,cost);
        int b= cost[i]+minCost(i+2,cost);
        return dp[i] = Math.min(a,b);
    }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(minCost(0,cost),minCost(1,cost));
    }
}