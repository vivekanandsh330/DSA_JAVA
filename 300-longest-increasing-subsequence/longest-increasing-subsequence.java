class Solution {
    int dp[][];

    int solve(int i, int prev, int nums[]) {
        if (i >= nums.length) {
            return 0;
        }
        if (prev != -1 && dp[i][prev] != -1) {
            return dp[i][prev];
        }
        int take = 0;

        if (prev == -1 || nums[prev] < nums[i]) {
            take = 1 + solve(i + 1, i, nums);
        }
        int skip = solve(i + 1, prev, nums);
        if (prev != -1)
            dp[i][prev] = Math.max(take, skip);

        return Math.max(take, skip);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1][n + 1];
        for (int i[] : dp) {
            Arrays.fill(i, -1);
        }
        return solve(0, -1, nums);
    }
}