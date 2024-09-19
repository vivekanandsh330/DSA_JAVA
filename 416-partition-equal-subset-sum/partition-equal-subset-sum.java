class Solution {
    Boolean dp[][];
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int num: nums){
            sum+=num;
        }
        dp=new Boolean[n+1][(sum/2)+1];
        if(sum%2 !=0){
            return false; 
        }
        return subsetSum(nums,sum/2,n);
    }
    boolean subsetSum(int []nums,int target,int n){
       if( n==0 && target>0){
        return false;
       }
        if(target == 0){
            return true;
        }
        if(dp[n][target] != null){
            return dp[n][target];
        }
        if(nums[n-1]<=target){
            return dp[n][target]=((subsetSum(nums,target-nums[n-1],n-1) )|| (subsetSum(nums,target,n-1)));
        }
        else{
            return dp[n][target]= subsetSum(nums,target,n-1);
        }
        
    }
}