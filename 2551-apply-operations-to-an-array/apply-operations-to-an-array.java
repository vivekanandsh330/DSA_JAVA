class Solution {
    public int[] applyOperations(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        for(int i=0;i<n-1;i++){
            if(nums[i] == nums[i+1]){
                nums[i]=2*nums[i];
                nums[i+1]=0;
            }
        }
        int count=0;
        for(int j=0;j<n;j++){
            if(nums[j] != 0){
            int temp=nums[count];
            nums[count]=nums[j];
            nums[j]=temp;
            count++;
            }
        }
        return nums;
    }
}