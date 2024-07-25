class Solution {
    public int[] sortArray(int[] nums) {
        TreeMap<Integer,Integer> hm=new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int ans[]=new int[nums.length];
        int i=0;
        for(int n: hm.keySet()){
            int c=hm.get(n);
            while(c-->0){
                ans[i++]=n;
            }
        }
        return ans;
    }
}