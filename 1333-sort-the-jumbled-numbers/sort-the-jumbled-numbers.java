class Solution {
     private static class Pair{
        int mn;
        int oi;
        Pair(int mn,int oi){
            this.mn=mn;
            this.oi=oi;
        }
    }
    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<Pair> ls=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            String ns=Integer.toString(nums[i]);
            String ms=getMapStr(ns,mapping);
            int mapn=Integer.parseInt(ms);
            ls.add(new Pair(mapn,i));
        }
        Collections.sort(ls,(a,b) -> Integer.compare(a.mn,b.mn));
        int ans[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int oni=ls.get(i).oi;
            ans[i]=nums[oni];
        }
        return ans;
    }
    String getMapStr(String ns,int[]mapping){
        StringBuilder map=new StringBuilder();
        for(char ch:ns.toCharArray()){
            map.append(mapping[ch-'0']);
        }
        return map.toString();
    }
}