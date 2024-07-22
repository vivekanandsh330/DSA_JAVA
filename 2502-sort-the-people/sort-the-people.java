class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
      Map<Integer,String> hm=new HashMap<>();
      for(int i=0;i<heights.length;i++){
        hm.put(heights[i],names[i]);
      }
     Arrays.sort(heights);
     String[]ans = new String[heights.length];
     int idx=0;
      for(int i=heights.length-1;i>=0;i--){
        ans[idx++]=hm.get(heights[i]);
      }
      return ans;
    }
}