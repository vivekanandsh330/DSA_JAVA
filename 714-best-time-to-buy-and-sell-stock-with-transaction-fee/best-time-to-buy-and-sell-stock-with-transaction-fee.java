class Solution {
    int dp[][];
    int solve(int i,int buy,int[]prices,int fee){
        if(i>=prices.length){
            return 0;
        }
        if(dp[i][buy] != -1){
            return dp[i][buy];
        }
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[i]+solve(i+1,0,prices,fee),solve(i+1,1,prices,fee));
        }
        else{
            profit=Math.max(prices[i]-fee+solve(i+1,1,prices,fee),solve(i+1,0,prices,fee));
        }
        return dp[i][buy]=profit;
    }
    public int maxProfit(int[] prices, int fee) {
        dp=new int[prices.length][2];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        return solve(0,1,prices,fee);
    }
}