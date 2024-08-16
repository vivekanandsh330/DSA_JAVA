class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min=arrays.get(0).get(0);
        int max=arrays.get(0).get(arrays.get(0).size()-1);
        int ans=0;
        for(int i=1;i<arrays.size();i++){
            int currmin=arrays.get(i).get(0);
            int currmax=arrays.get(i).get(arrays.get(i).size()-1);
            ans=Math.max(ans,Math.max(Math.abs(currmin-max),Math.abs(currmax-min)));
            min= Math.min(min,currmin);
            max=Math.max(max,currmax);
        }
        return ans;
    }
}