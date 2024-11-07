class Solution {
    int dp[][];
    int solve(int i, int curror, int maxor, int[] nums) {
        if (i >= nums.length) {
            if (curror == maxor) {
                return 1;
            }
            return 0;
        }
        if(dp[i][curror] !=-1){
            return dp[i][curror];
        }
        int take = solve(i + 1, curror | nums[i], maxor, nums);
        int skip = solve(i + 1, curror, maxor, nums);
        return dp[i][curror]=take + skip;
    }

    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int maxor = 0;
        for (int num : nums) {
            maxor |= num;
        }
        dp=new int[n+1][maxor+1];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        return solve(0, 0, maxor, nums);
    }
}