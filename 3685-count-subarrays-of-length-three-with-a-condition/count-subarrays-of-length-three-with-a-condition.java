class Solution {
    public int countSubarrays(int[] nums) {
        int n=nums.length;
        int count=0;
        for(int i=2;i<n;i++){
            if(nums[i-1] == 2*(nums[i]+nums[i-2])){
                count++;
            }
        }
        return count;
    }
}