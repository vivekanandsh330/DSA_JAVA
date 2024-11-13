class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            int low = lowerBound(nums, i + 1, nums.length, lower - nums[i]);
            int up = upperBound(nums, i + 1, nums.length, upper - nums[i]);
            ans += up - low;
        }
        return ans;
    }

    int lowerBound(int[] nums, int s, int e, int t) {
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] >= t) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }

    int upperBound(int[] nums, int s, int e, int t) {
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] > t) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }
}