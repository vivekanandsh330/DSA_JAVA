class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int []dp=new int[nums.length];
        if(nums.length <3){
            return 0;
        }
        dp[0]=dp[1]=0;
        int ans=0;
        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
                dp[i]=1+dp[i-1];
                ans+=dp[i];
            }

        }
        return ans;
    }
}