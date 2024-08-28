class Solution {
    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private boolean checkSubIsland(int[][] grid1, int[][] grid2, int i, int j) {
        int m = grid1.length;
        int n = grid1[0].length;
        boolean result = true;
        Queue<int[]> queue = new LinkedList<>(); 
        queue.offer(new int[]{i, j});
        grid2[i][j] = -1; 
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (grid1[x][y] != 1) { 
                result = false;
            }

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid2[newX][newY] == 1) {
                    grid2[newX][newY] = -1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return result;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int subIslands = 0;
        int m = grid2.length; 
        int n = grid2[0].length; 

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && checkSubIsland(grid1, grid2, i, j)) {
                    subIslands++;
                }
            }
        }
        return subIslands;
    }
}