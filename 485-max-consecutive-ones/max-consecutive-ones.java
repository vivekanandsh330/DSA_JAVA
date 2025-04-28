class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cone=0;
        int maxc=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] == 1){
                cone++;
            }
            else if(nums[i] == 0){
                maxc=Math.max(maxc,cone);
                cone=0;
            }
        }
        maxc=Math.max(maxc,cone);
        return maxc;
    }
}