class Solution {
    int n;
    int dp[][];
    int solve(int idx,int amount,int[] coins){
        if(amount == 0){
            return 1;
        }
        if(idx == n){
            return 0;
        }
        if(dp[idx][amount] != -1){
            return dp[idx][amount];
        }
        if(amount<coins[idx]){
            return  dp[idx][amount]=solve(idx+1,amount,coins);
        }

        int include=solve(idx,amount-coins[idx],coins);
        int exclude=solve(idx+1,amount,coins);

        return  dp[idx][amount]=include+exclude;
    }
    public int change(int amount, int[] coins) {
     n=coins.length;
     dp=new int[n+1][amount+1];
     for(int i[]: dp){
        Arrays.fill(i,-1);
     }
     return solve(0,amount,coins);
    }
}