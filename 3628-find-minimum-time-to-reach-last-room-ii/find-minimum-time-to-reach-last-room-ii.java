class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] { 0, 0, 0, 0 });
        int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int timetoMove[][] = new int[n][m];
        for (int row[] : timetoMove) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        timetoMove[0][0] = 0;
        while (!pq.isEmpty()) {
            int curr[] = pq.poll();
            int t = curr[0];
            int r = curr[1];
            int c = curr[2];
            int moves = curr[3];
            if (r == n - 1 && c == m - 1) {
                return t;
            }
            for (int dir[] : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                int tomove = (moves % 2 == 0) ? 1 : 2;
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int tc = Math.max(t, moveTime[nr][nc]) + tomove;
                    if (tc < timetoMove[nr][nc]) {
                        timetoMove[nr][nc] = tc;
                        pq.add(new int[] { tc, nr, nc, moves + 1 });
                    }
                }
            }
        }
        return -1;
    }
}