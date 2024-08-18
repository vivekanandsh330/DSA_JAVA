class Solution {
    public int nthUglyNumber(int n) {
        Set<Long> set = new TreeSet<>();
        set.add(1L);
        for (int i = 0; i < n - 1; i++) {
            long val = set.iterator().next();
            set.remove(val);
            set.add(val * 2);
            set.add(val * 3);
            set.add(val * 5);
        }
        return set.iterator().next().intValue();
    }
}