class Solution {
    int dp[]=new int[101];
    int solve(int i,int nums[],int j){
        if(i>j){
            return 0;
        }
       
        if(dp[i] != -1){
            return dp[i];
        }
            int t=nums[i]+solve(i+2,nums,j);
            int nt=solve(i+1,nums,j);
            return dp[i]= Math.max(t,nt);
    }
    public int rob(int[] nums) {
       int n=nums.length;
      
       if(n == 1){
        return nums[0];
       }
       if(n == 2){
        return Math.max(nums[0],nums[1]);
       }
       
       Arrays.fill(dp,-1);
       int ans1=solve(0,nums,n-2);
       Arrays.fill(dp,-1);
       int ans2=solve(1,nums,n-1);
       return Math.max(ans1,ans2);
    }
}