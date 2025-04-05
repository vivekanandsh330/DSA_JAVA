class Solution {
    int n;
    int dp[][];
    int solve(int idx,int[] coins, int amount){
        if(idx==0){
            if(amount%coins[0] == 0){
                return amount/coins[0];
            }
            else{
                return (int)1e9;
            }
        }
        if(dp[idx][amount] != -1){
            return dp[idx][amount];
        }
        int nottake=solve(idx-1,coins,amount);
        int take=Integer.MAX_VALUE;
        if(coins[idx]<=amount){
            take=1+solve(idx,coins,amount-coins[idx]);
        }
        return dp[idx][amount]=Math.min(take,nottake);
    }
    public int coinChange(int[] coins, int amount) {
        n=coins.length;
        dp=new int[n+1][amount+1];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        int ans= solve(n-1,coins,amount);
        if(ans>=1e9){
            return -1;
        }
        return ans;
    }
}