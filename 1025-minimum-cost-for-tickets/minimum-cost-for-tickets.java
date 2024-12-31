class Solution {
    int dp[]=new int[1001];
    int solve(int[] days, int[] costs, int idx) {
        if (idx >= days.length) {
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int oned = costs[0] + solve(days, costs, idx + 1);
        int j = idx;
        int maxd = days[idx] + 7;
        while (j < days.length && days[j] < maxd) {
            j++;
        }
        int sevend = costs[1] + solve(days, costs, j);
        j = idx;
        maxd = days[idx] + 30;
        while (j < days.length && days[j] < maxd) {
            j++;
        }
        int thirdd = costs[2] + solve(days, costs, j);

        return dp[idx]=Math.min(thirdd, Math.min(oned, sevend));
    }

    public int mincostTickets(int[] days, int[] costs) {
        Arrays.fill(dp,-1);
        return solve(days, costs, 0);
    }
}