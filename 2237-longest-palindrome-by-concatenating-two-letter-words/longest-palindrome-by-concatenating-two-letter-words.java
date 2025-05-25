class Solution {
    public int longestPalindrome(String[] words) {
        Map<String,Integer> hm=new HashMap<>();
        int ans=0;
        for(String word:words){
            String rev=new StringBuilder(word).reverse().toString();
            if(hm.getOrDefault(rev,0) >0){
                ans+=4;
                hm.put(rev,hm.get(rev)-1);
            }
            else{
                hm.put(word,hm.getOrDefault(word,0)+1);
            }
        }
        for(String str: hm.keySet()){
            if(str.charAt(0) == str.charAt(1) && hm.get(str)>0){
                ans+=2;
                break;
            }
        }
        return ans;
    }
}