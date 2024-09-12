class Solution {
    int dp[][][];
    int solve(int i,int buy,int[] prices,int count){
         if(count > 2){
                return(int) -1e7;
            }
        if(i >= prices.length ){
            return 0;
        }
        if(dp[i][buy][count] != -1){
            return dp[i][buy][count];
        }
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[i]+solve(i+1,0,prices,count),solve(i+1,1,prices,count));
        }
        else{
            profit=Math.max(prices[i]+solve(i+1,1,prices,count+1),0+solve(i+1,0,prices,count));
        }
        return dp[i][buy][count]=profit;
    }
    public int maxProfit(int[] prices) {
        dp=new int[prices.length][2][3];
        for(int i[][]:dp){
            for(int j[]:i ){
            Arrays.fill(j,-1);
            }
        }
        return solve(0,1,prices,0);
        
    }
}