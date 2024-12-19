class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int prefixmax[] = Arrays.copyOf(arr, n);
        int suffixmin[] = Arrays.copyOf(arr, n);

        for (int i = 1; i < n; i++) {
            prefixmax[i] = Math.max(prefixmax[i - 1], prefixmax[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            suffixmin[i] = Math.min(suffixmin[i], suffixmin[i + 1]);
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            int phlekamax = i > 0 ? prefixmax[i - 1] : -1;
            int badkamin = suffixmin[i];
            if (phlekamax < badkamin) {
                count++;
            }
        }
        return count;
    }
}