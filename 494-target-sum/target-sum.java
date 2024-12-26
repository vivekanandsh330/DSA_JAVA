class Solution {
    int solve(int []nums,int i,int currsum,int target){
        if(i == nums.length){
            if(currsum == target){
                return 1;
            }
            else{
                return 0;
            }
        }

        int plus=solve(nums,i+1,currsum+nums[i],target);
        int minus=solve(nums,i+1,currsum-nums[i],target);

        return plus+minus;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums,0,0,target);
    }
}