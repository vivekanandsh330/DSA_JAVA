class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        Map<Integer,Integer> hm=new HashMap<>();
        int n=nums.length;
        int ms=n/3;
        for(int num:nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        for(int el:hm.keySet()){
            if(hm.get(el)>ms){
                ans.add(el);
            }
        }
        return ans;
        
    }
}