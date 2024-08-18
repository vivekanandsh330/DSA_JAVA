class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        for (int i = 0; i < n - 1; i++) {
            long val = set.pollFirst();
            set.add(val * 2);
            set.add(val * 3);
            set.add(val * 5);
        }
        return set.first().intValue();
    }
}