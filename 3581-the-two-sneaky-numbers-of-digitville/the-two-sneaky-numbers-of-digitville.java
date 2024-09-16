class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int num: nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        int ans[]=new int[2];
        int i=0;
        for(int n: hm.keySet()){
            if(hm.get(n)>1){
                ans[i++]=n;
            }
        }
        return ans;
        
    }
}