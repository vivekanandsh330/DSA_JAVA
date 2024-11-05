class Solution {
    long dp[][];
    long solve(int i, boolean flag, int[] nums) {
        if (i >= nums.length) {
            return 0;
        }
        int even = flag ? 1:0;
        if(dp[i][even] != -1){
            return dp[i][even];
        }
        long val = nums[i];
        if (flag == false) {
            val = -val;
        }
        long take = solve(i + 1, !flag, nums) + val;
        long skip = solve(i + 1, flag, nums);
        return dp[i][even]=Math.max(take, skip);
    }

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        dp=new long[n+1][2];
        for(long i[]:dp){
            Arrays.fill(i,-1);
        }
        return solve(0, true, nums);
    }
}