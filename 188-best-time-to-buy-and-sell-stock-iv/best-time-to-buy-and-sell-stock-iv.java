class Solution {
    int dp[][][];
    int solve(int i,int buy,int k,int[] prices){
        if(k == 0){
            return 0;
        }
        if(i == prices.length){
            return 0;
        }
        if(dp[i][buy][k] !=-1){
            return dp[i][buy][k];
        }
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[i]+solve(i+1,0,k,prices),0+solve(i+1,1,k,prices));
        }
        else{
            profit=Math.max(prices[i]+solve(i+1,1,k-1,prices),0+solve(i+1,0,k,prices));
        }
        return dp[i][buy][k]= profit;
    }
    public int maxProfit(int k, int[] prices) {
        dp=new int[prices.length][2][k+1];
        for(int i[][]:dp){
            for(int j[]:i){
                Arrays.fill(j,-1);
            }
        }
        return solve(0,1,k,prices);
    }
}