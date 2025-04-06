class Solution {
    int n;
    Integer dp[][];
    boolean solve(int idx,int target,int [] nums){
        if(idx == n){
            return false;
        }
        if(target == 0){
            return true;
        }
        if(dp[idx][target] != null){
            return dp[idx][target] == 1;
        }
        boolean take=false;
        if(nums[idx]<=target){
        take=solve(idx+1,target-nums[idx],nums);
        }
        boolean nottake=solve(idx+1,target,nums);
        dp[idx][target]= (take || nottake) ? 1:0;
        return take || nottake;
    }
    public boolean canPartition(int[] nums) {
        n=nums.length;
        int totalval=Arrays.stream(nums).sum();
        if(totalval % 2 != 0){
            return false;
        }
        dp=new Integer[n+1][(totalval/2)+1];
        return solve(0,totalval/2,nums);

    }
}