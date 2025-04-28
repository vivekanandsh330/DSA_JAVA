class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        
            int l=0;
            int r=0;
            int zero=0;
            int maxlen=0;
            while(r<n){
                if(nums[r] == 0){
                    zero++;
                }
                if(zero> k){
                    if(nums[l] == 0){
                        zero--;
                    }
                    l++;
                }
                if(zero<=k){
                    maxlen=Math.max(maxlen,r-l+1);
                }
                r++;
            }
        
        return maxlen;
    }
}