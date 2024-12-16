class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[] { nums[i], i });
        }

        int ans[] = new int[nums.length];
        while (k-- > 0) {
            int curr[] = pq.poll();
            int val = curr[0];
            int idx = curr[1];
            pq.add(new int[] { val * multiplier, idx });
        }

        while (!pq.isEmpty()) {
            ans[pq.peek()[1]] = pq.poll()[0];
        }
        return ans;
    }
}