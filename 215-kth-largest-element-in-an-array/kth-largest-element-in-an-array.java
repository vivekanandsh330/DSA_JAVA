class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        if(nums.length==0)
        {
            return 0;
        }
        int p =nums.length;
            return nums[p-k];
         
        
    }
}