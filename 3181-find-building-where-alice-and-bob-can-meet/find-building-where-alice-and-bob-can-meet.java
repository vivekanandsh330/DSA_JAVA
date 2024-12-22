import java.util.*;

class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int totalQueries = queries.length;

        // Array to store the answer for each query
        int[] ans = new int[totalQueries];
        Arrays.fill(ans, -1);

        // Map to store remaining queries as max index -> List of (max height, query number)
        Map<Integer, List<int[]>> map = new HashMap<>();

        // Min-heap (priority queue) to process queries based on height
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // 1 : Answer basic queries and create map for remaining
        for (int q = 0; q < totalQueries; q++) {
            int i = queries[q][0];
            int j = queries[q][1];
            if (i < j && heights[i] < heights[j]) {
                ans[q] = j;
            } else if (i > j && heights[i] > heights[j]) {
                ans[q] = i;
            } else if (i == j) {
                ans[q] = i;
            } else {
                map.computeIfAbsent(Math.max(i, j), k -> new ArrayList<>())
                   .add(new int[]{Math.max(heights[i], heights[j]), q});
            }
        }

        // 2 : Use priority queue to handle remaining queries
        for (int i = 0; i < n; i++) {
            // Check which queries can be answered with index i
            while (!pq.isEmpty() && pq.peek()[0] < heights[i]) {
                ans[pq.poll()[1]] = i;
            }
            // Push queries with max index as i into the priority queue
            if (map.containsKey(i)) {
                for (int[] it : map.get(i)) {
                    pq.offer(it);
                }
            }
        }

        return ans;
    }
}
