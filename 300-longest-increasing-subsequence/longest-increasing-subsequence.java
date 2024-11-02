class Solution {
    public int lengthOfLIS(int[] arr) {
        int dp[] = new int[arr.length];
        Arrays.fill(dp, 1);
        int maxLIS = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLIS = Math.max(dp[i], maxLIS);
                }
            }
        }
        return maxLIS;
    }
}