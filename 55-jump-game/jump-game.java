class Solution {
    int dp[]; 
    int solve(int nums[], int n, int idx) {
        if (idx == n - 1) {
            return 1;  
        }
        if (dp[idx] != -1) {
            return dp[idx];  
        }
        for (int i = 1; i <= nums[idx]; i++) { 
            if (solve(nums, n, idx + i) == 1) {
                return dp[idx] = 1;  
            }
        }
        return dp[idx] = 0;  
    }
    public boolean canJump(int[] nums) {
        int n = nums.length;
        dp = new int[10001];  
        Arrays.fill(dp, -1); 
        return solve(nums, n, 0) == 1;  
    }
}
