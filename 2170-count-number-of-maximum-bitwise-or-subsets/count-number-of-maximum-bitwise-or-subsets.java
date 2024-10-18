class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxor=0;
        for(int num:nums){
            maxor |= num;
        }
        int curror=0;
        return findmaxsubset(nums,0,curror,maxor);
    }
    int findmaxsubset(int []nums,int idx,int curror,int maxor){
        if(idx>=nums.length){
            if(curror==maxor){
                return 1;
            }else{
                return 0;
            }
        }
        int include= findmaxsubset(nums,idx+1,curror | nums[idx],maxor);
        int exclude= findmaxsubset(nums,idx+1,curror,maxor);
        return include+exclude;
    }
}