class Solution {
    public int maxWidthRamp(int[] nums) {
        int n=nums.length;
        int arr[]=new int[nums.length];
        arr[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            arr[i]=Math.max(arr[i+1],nums[i]);
        }
        int max=0;
        int i=0;
        int j=0;;
        while(j<nums.length){
           while(i<j && nums[i]>arr[j]){
            i++;
           }
           max=Math.max(max,j-i);
           j++;
        }
        return max;
    }
}