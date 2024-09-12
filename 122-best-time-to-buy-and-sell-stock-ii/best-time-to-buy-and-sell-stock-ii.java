class Solution {
    int dp[][];
    int solve(int i,int buy,int[] prices){
        int n=prices.length;
        if(i == n){
            return 0;
        }
        if(dp[i][buy] != -1){
            return dp[i][buy];
        }
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[i]+solve(i+1,0,prices),0+solve(i+1,1,prices));
        }
        else{
            profit=Math.max(prices[i]+solve(i+1,1,prices),0+solve(i+1,0,prices));
        }
        return dp[i][buy]=profit;
    }
    public int maxProfit(int[] prices) {
        dp=new int[prices.length][2];
        for(int []i:dp){
            Arrays.fill(i,-1);
        }

        return solve(0,1,prices);
    }
}