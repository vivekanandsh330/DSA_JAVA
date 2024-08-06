class Solution {
    public int minimumPushes(String word) {
      int[] hm= new int[26];
      for(char ch : word.toCharArray()){
        hm[ch-'a']++;
      }
      Integer[] hmint=Arrays.stream(hm).boxed().toArray(Integer[]::new);
      Arrays.sort(hmint,Comparator.reverseOrder());

      int ans=0;
      for(int i=0;i<26;i++){
        ans +=hmint[i]*((i/8)+1);
      }
      return ans;
    }
}