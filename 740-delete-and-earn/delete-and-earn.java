class Solution {
    int n;
    int dp[];
    int solve(int []fre,int idx){
        if(idx<=0){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int take=fre[idx]+solve(fre,idx-2);
        int nottake=solve(fre,idx-1);
        return dp[idx]=Math.max(take,nottake);
    }
    public int deleteAndEarn(int[] nums) {
        n=nums.length;
        int maxVal=Arrays.stream(nums).max().getAsInt();

        int fre[]=new int[maxVal+1];
        for(int num:nums){
            fre[num] += num;
        }
        dp=new int[maxVal+1];
        Arrays.fill(dp,-1);

        return solve(fre,maxVal);

    }
}