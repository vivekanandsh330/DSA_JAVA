class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int maxv = values[0] + 0;
        int ans = 0;

        for (int j = 1; j < n; j++) {
            int x = values[j] - j;
            int y = maxv;
            ans = Math.max(ans, x + y);
            maxv = Math.max(maxv, values[j] + j);
        }
        return ans;
    }
}