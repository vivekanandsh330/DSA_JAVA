class Solution {
    int dp[][];
    int dfs(int i, int j, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dirs[] = { -1, 0, 1 };
        int max = 0;
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        for (int dir : dirs) {
            int newr = i + dir;
            int newc = j + 1;
            if (newr>=0 && newr<n && newc>=0 && newc <m && grid[newr][newc] > grid[i][j]) {
                max = Math.max(max, 1 + dfs(newr, newc, grid));
            }
        }
        return dp[i][j]=max;
    }

    public int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp=new int[n+1][m+1];
        for(int i[]: dp){
            Arrays.fill(i,-1);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i, 0, grid));
        }
        return ans;
    }
}