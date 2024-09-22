class Solution {
    public long validSubstringCount(String word1, String word2) {
        HashMap<Character,Integer> hm1=new HashMap<>();
        for(char ch1:word2.toCharArray()){
            hm1.put(ch1,hm1.getOrDefault(ch1,0)+1);
        }

        HashMap<Character,Integer> hm2=new HashMap<>();
        int j=0;
        long ans=0;
        int requiredMatches = hm1.size();
        int matched = 0;

        for(int i=0;i<word1.length();i++){
            char currch=word1.charAt(i);
            hm2.put(currch,hm2.getOrDefault(currch,0)+1);

            if (hm1.containsKey(currch) && hm2.get(currch).equals(hm1.get(currch))) {
                matched++;
            }

            while(j<=i && matched == requiredMatches){
                ans += word1.length()-i;
                char str=word1.charAt(j);
                hm2.put(str,hm2.get(str)-1);
                if (hm1.containsKey(str) && hm2.get(str) < hm1.get(str)) {
                    matched--;
                }
                j++;
            }
        }
        return ans;
    }
}