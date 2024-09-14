class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int currsum=0;
        int currlen=0;
        int minlen=Integer.MAX_VALUE;
        int left=0;
        int right=0;
        while(right < nums.length){
            currsum +=nums[right];
            while(currsum >=target){
                currlen=right-left+1;
                minlen=Math.min(currlen,minlen); 
                int leftelm=nums[left];
                currsum -=leftelm;
                left++;
            }
              right++;
        }
        return minlen == Integer.MAX_VALUE ? 0 :minlen;
    }
}