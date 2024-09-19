class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int num: nums){
            sum+=num;
        }
        if(sum%2 !=0){
            return false; 
        }
        return subsetSum(nums,sum/2,n);
    }
    boolean subsetSum(int []nums,int target,int n){
      Boolean dp[][]=new Boolean[n+1][target+1];
      dp[0][0]=true;
      for(int i=0;i<n+1;i++){
        for(int j=0;j<target+1;j++){
            if(i == 0){
                dp[i][j]= false;
            }
            if(j == 0){
            dp[i][j]= true;
            }
        }
      }
      for(int i=1;i<n+1;i++){
        for(int j=1;j<target+1;j++){
            if(nums[i-1]<=j){
                dp[i][j]= ((dp[i-1][j-nums[i-1]]) || (dp[i-1][j]));
            }
            else{
                dp[i][j]= dp[i-1][j];
            }
      }
      }
      return dp[n][target];
        
    }
}