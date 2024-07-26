class Solution {
    void floydWarshall(int n, int[][] shortestPathMatrix) {
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    shortestPathMatrix[i][j] = Math.min(shortestPathMatrix[i][j],
                                                        shortestPathMatrix[i][via] + shortestPathMatrix[via][j]);
                }
            }
        }
    }

    int getCityWithFewestReachable(int n, int[][] shortestPathMatrix, int distanceThreshold) {
        int cityWithFewestReachable = -1;
        int fewestReachableCount = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && shortestPathMatrix[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }

            if (reachableCount <= fewestReachableCount) {
                fewestReachableCount = reachableCount;
                cityWithFewestReachable = i;
            }
        }
        return cityWithFewestReachable;
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] shortestPathMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(shortestPathMatrix[i], (int) 1e9 + 7);
            shortestPathMatrix[i][i] = 0;  
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            shortestPathMatrix[u][v] = wt;
            shortestPathMatrix[v][u] = wt;
        }
        floydWarshall(n, shortestPathMatrix);

        return getCityWithFewestReachable(n, shortestPathMatrix, distanceThreshold);
    }
}