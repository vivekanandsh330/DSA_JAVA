class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
        return backtrack(nums, 0, 1, 0, 1, 0, target);
    }

    private boolean backtrack(int[] nums, int i, long prodA, int sizeA, long prodB, int sizeB, long target) {
        if (i == nums.length) {
            return sizeA > 0 && sizeB > 0 && prodA == target && prodB == target;
        }

        // Include nums[i] in subset A
        if (prodA * nums[i] <= target) {
            if (backtrack(nums, i + 1, prodA * nums[i], sizeA + 1, prodB, sizeB, target)) {
                return true;
            }
        }

        // Include nums[i] in subset B
        if (prodB * nums[i] <= target) {
            if (backtrack(nums, i + 1, prodA, sizeA, prodB * nums[i], sizeB + 1, target)) {
                return true;
            }
        }

        return false;
    }
}
