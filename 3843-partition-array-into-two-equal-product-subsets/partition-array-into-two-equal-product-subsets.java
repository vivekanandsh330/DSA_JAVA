class Solution {
    boolean solve(int nums[],int i,long pa,int sa,long pb,int sb,long target){
        if(i == nums.length){
            return sa>0 && sb>0 && pa == target && pb == target;
        }

        if(pa*nums[i] <= target){
            if(solve(nums,i+1,pa*nums[i],sa+1,pb,sb,target)){
                return true;
            }
        }
        if(pb*nums[i]<=target){
            if(solve(nums,i+1,pa,sa,pb*nums[i],sb+1,target)){
                return true;
            }
        }
        return false;
    }
    public boolean checkEqualPartitions(int[] nums, long target) {
        return solve(nums,0,1,0,1,0,target);
    }
}