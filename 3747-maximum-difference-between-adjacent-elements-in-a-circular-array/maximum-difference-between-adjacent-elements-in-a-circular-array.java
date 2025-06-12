class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n=nums.length;
        int maxdiff=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
           maxdiff=Math.max(maxdiff,Math.abs(nums[i]-nums[(i+1)%n]));
        }
        return maxdiff;
    }
}