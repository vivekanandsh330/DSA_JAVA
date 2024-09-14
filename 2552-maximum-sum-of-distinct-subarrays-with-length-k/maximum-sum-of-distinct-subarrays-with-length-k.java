class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
       long currsum=0;
       long maxsum=0;
       int left=0;
       HashMap<Integer,Integer> hm=new HashMap<>();
       for(int i=0;i<nums.length;i++){
        currsum += nums[i];
        hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        if(i-left+1 >k){
            int leftsum=nums[left];
            currsum -=leftsum;
            hm.put(leftsum,hm.get(leftsum)-1);
            if(hm.get(leftsum) == 0){
                hm.remove(leftsum);
            }
            left++;
        }
        if(i-left+1 == k && hm.size() == k){
            maxsum =Math.max(maxsum,currsum);
        }
       }
       return maxsum;
    }
}