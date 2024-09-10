class Solution {
    public int minSwaps(int[] nums) {
        // window size number of 1's
        int windowsize=0;
        for(int num:nums){
            if(num==1){
                windowsize++;
            }
        }
        // count number of 0's b/w widowsize
        int currzero=0;
        for(int i=0;i<windowsize;i++){
            if(nums[i]==0){
                currzero++;
            }
        }
        //solve for remaining element
        int minzero=currzero;
        int start=0;
        int end=windowsize-1;
        while(start<nums.length){
            // remove element is 0's than reduce currzero
            if(nums[start]==0){
                currzero--;
            }
            start++;

            // sliding elment contains 0's than increment the currzero
            end++;
            if(nums[end%nums.length] == 0){
                currzero++;
            }
            minzero=Math.min(minzero,currzero);
        }
        return minzero;
    }
}