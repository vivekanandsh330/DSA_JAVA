class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int max=0;
        if(nums[0] <0 && n == 1){
            return nums[0];
        }
        for(int i=0;i<n;i++){
            int p=1;
            for(int j =i;j<n;j++){
                p *= nums[j];
                 max=Math.max(max,p);
            }
        }
        return max;
    }
}