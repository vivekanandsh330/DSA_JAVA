class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        List<Integer> list =new ArrayList<>(hm.keySet());
        Collections.sort(list, (a,b)->{
          if(hm.get(a) == hm.get(b)){
            return b-a;
          }
          else 
          {
            return hm.get(a)-hm.get(b);
          }
        });
        int []ans=new int[nums.length];
        int idx=0;
        for(int num: list){
            for(int i=0;i<hm.get(num);i++){
                ans[idx++]=num;
            }
        }
        return ans;
    }
}