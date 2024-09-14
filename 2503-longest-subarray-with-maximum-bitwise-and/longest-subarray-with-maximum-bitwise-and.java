class Solution {
    public int longestSubarray(int[] nums) {
       int maxval=0;
       int streak=0;
       int ans=0;
       for(int num:nums){
        if(num>maxval){
            maxval=num;
            streak=0;
            ans=0;
        }
        if(maxval == num){
            streak++;
        }else{
            streak=0;
        }
        ans=Math.max(ans,streak);
       }
       return ans;
    }
}