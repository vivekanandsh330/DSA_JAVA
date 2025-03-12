class Solution {
    public int maximumCount(int[] nums) {
        int l=nums.length;
        int p=0;
        int n=0;
        int max=0;

        for(int i=0;i<l;i++){
            if(nums[i]<0){
                n++;
            }else if (nums[i] == 0){
                continue;
            }
            else{
                p++;}
            max =Math.max(p,n);
        }
        return max;
    }
}