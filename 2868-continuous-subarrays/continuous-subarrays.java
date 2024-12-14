class Solution {
    public long continuousSubarrays(int[] nums) {
        int n=nums.length;
        TreeMap<Integer,Integer> hm=new TreeMap<>();
        long ans=0;
        int i=0;
        int j=0;
        while(j<n){
            hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
            while(Math.abs(hm.lastKey()-hm.firstKey())>2){
                hm.put(nums[i],hm.get(nums[i])-1);
                if(hm.get(nums[i]) == 0){
                    hm.remove(nums[i]);
                }
                i++;
            }
            ans += j-i+1;
            j++;
        }
        return ans;
    }
}