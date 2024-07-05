class Solution {
    int dp[][];
    int solve(int []nums,int total,int i){
        if(i == nums.length){
            if(total == 0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[i][total+1000] != -1){
            return dp[i][total+1000];
        }
        int take=solve(nums,total+nums[i],i+1);
        int skip=solve(nums,total-nums[i],i+1);
        return dp[i][total+1000]=take+skip;
      }
    public int findTargetSumWays(int[] nums, int target) { 
        dp=new int[21][5000];
        for(int nu[]:dp){
            Arrays.fill(nu,-1);
        }
      return solve(nums,target,0);
    }
}