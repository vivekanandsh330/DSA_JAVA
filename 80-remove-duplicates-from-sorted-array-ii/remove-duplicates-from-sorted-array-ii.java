class Solution {
    public int removeDuplicates(int[] nums) {
       int n=nums.length;
       int i=0;
       int j=0;
       while(j<n){
        if(i<2 || nums[j] != nums[i-2]){
            nums[i++]=nums[j];
        }
        j++;
       }
       return i;
    }
}