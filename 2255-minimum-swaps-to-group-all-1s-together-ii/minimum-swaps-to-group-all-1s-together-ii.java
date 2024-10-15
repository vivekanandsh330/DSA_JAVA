class Solution {
    public int minSwaps(int[] nums) {
      int n=nums.length;
      int count1=0;
      for(int i=0;i<n;i++){
        if(nums[i] == 1){
            count1++;
        }
      }
      if(count1 == 0 || count1 == n){
        return 0;
      }
      int total=0;
      for(int i=0;i<count1;i++){
        total+=nums[i];
      }
      int swap=count1-total;
      for(int i=count1;i<n+count1;i++){
        total+=nums[i%n];
        total-=nums[(i-count1)%n];
        swap=Math.min(swap,count1-total);
      }
      return swap;
    }
}