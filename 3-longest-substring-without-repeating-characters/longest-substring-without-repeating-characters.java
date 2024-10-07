class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int i=0;
        int j=0;
        int maxlen=0;
        int k=0;
        HashMap<Character,Integer> hm=new HashMap<>();
        while(j<n){
            k=j-i+1;
            hm.put(s.charAt(j),hm.getOrDefault(s.charAt(j),0)+1);
            if(hm.size() == k){
                maxlen=Math.max(maxlen,j-i+1);
            }
            else{
                while(hm.size()<k){
                    char ch=s.charAt(i);
                    hm.put(ch,hm.get(ch)-1);
                    if(hm.get(ch) == 0){
                        hm.remove(ch);
                    }
                    i++;
                    k--;
                }
                if(hm.size() == k){
                    maxlen=Math.max(maxlen,j-i+1);
                }
            }
            j++;
        }
        return maxlen;
    }
}