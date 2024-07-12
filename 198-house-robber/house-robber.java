class Solution {
    int dp[];
    int solve(int i,int n,int[]nums){
        if(i >n){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int in= nums[i]+solve(i+2,n,nums);
        int ex=solve(i+1,n,nums);
        return dp[i]= Math.max(in,ex);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(0,n-1,nums);
        
    }
}