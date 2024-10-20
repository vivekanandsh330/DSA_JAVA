class Solution {
    public int numberOfSubstrings(String s, int k) {
        int l=0;
        int ans=0;
        Map<Character,Integer> hm=new HashMap<>();
        for(char ch:s.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            while(hm.get(ch) == k){
                hm.put(s.charAt(l),hm.get(s.charAt(l))-1);
                l++;
            }
            ans+=l;
        }
        return ans;
    }
}