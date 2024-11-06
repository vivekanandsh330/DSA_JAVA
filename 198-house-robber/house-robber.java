class Solution {
    int dp[];
    int solve(int i,int [] nums){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int take=0;
       
        take=nums[i]+solve(i+2,nums);
        
        int skip=solve(i+1,nums);
        return dp[i]=Math.max(take,skip);
    }
    public int rob(int[] nums) {
        dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return solve(0,nums);
    }
}