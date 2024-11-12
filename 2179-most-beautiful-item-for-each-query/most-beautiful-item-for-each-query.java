class Solution {
    int upperBound(int[][] items, int idx) {
        int l = 0;
        int h = items.length;
        while (l < h) {
            int mid = (l + h) / 2;
            if (items[mid][0] <= idx) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int maxi = 0;
        int maxarr[] = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            maxi = Math.max(maxi, items[i][1]);
            maxarr[i] = maxi;
        }
        int ans[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int idx = upperBound(items, queries[i]);
            if (idx == 0) {
                ans[i] = 0;
            } else {
                ans[i] = maxarr[idx - 1];
            }
        }
        return ans;
    }

}