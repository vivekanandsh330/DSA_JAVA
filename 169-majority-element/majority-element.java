class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int mj=n/2;
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        for(int num:hm.keySet()){
            if(hm.get(num)>mj){
                return num;
            }
        }
        return -1;
        
    }
}