class Solution {
    public boolean validMountainArray(int[] nums) {
        int n=nums.length;
        if(n<3){
            return false;
        }
        int peak=0;
        for(int i=1;i<=n-2;i++){
             if(nums[i]>nums[i-1] && nums[i]>nums[i+1]){
                peak++;
                if(peak>1){
                return false;
                }
             }
             if(nums[i]==nums[i-1] || nums[i]==nums[i+1]){
                return false;
             }
             if(nums[i]<nums[i-1] && nums[i] <nums[i+1]){
                return false;
             }
        }
        return peak == 1;
    }
}