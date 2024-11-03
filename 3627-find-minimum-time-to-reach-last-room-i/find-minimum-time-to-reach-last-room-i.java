class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] { 0, 0, 0 });
        int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        boolean vis[][] = new boolean[n][m];
        while (!pq.isEmpty()) {
            int curr[] = pq.poll();
            int t = curr[0];
            int r = curr[1];
            int c = curr[2];
            if (r == n - 1 && c == m - 1) {
                return t;
            }
            for (int dir[] : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc]) {
                    pq.add(new int[] { Math.max(t, moveTime[nr][nc]) + 1, nr, nc });
                    vis[nr][nc] = true;
                }
            }
        }
        return -1;

    }
}