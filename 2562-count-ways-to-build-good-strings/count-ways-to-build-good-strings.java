class Solution {
    int mod=(int)1e9+7;
    int dp[];
    int solve(int low, int high, int zero, int one,int l){
        if(l >high){
            return 0;
        }
        boolean addone=false;
        if(l >= low  && l <= high){
            addone= true;
        }
        if(dp[l] != -1){
            return dp[l];
        }
        int in=solve(low,high,zero,one,l+one);
        int ex=solve(low,high,zero,one,l+zero);
        return dp[l]=(addone ? 1:0)+(in+ex)%mod;
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        dp=new int[high+1];
        Arrays.fill(dp,-1);
        return solve(low,high,zero,one,0);
    }
}