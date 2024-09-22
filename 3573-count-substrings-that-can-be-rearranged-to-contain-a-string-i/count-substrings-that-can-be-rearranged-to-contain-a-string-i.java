class Solution {
    public long validSubstringCount(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        HashMap<Character,Integer> hm1=new HashMap<>();
        for(char ch1:word2.toCharArray()){
            hm1.put(ch1,hm1.getOrDefault(ch1,0)+1);
        }
        HashMap<Character,Integer> hm2=new HashMap<>();
        int j=0;
        long ans=0;
        for(int i=0;i<n;i++){
            char ch2=word1.charAt(i);
            hm2.put(ch2,hm2.getOrDefault(ch2,0)+1);
            boolean flag=true;
            for(char ch:hm1.keySet()){
                if(hm1.get(ch)>hm2.getOrDefault(ch,0)){
                    flag=false;
                    break;
                }
            }
            while(j<=i && flag == true){
                ans +=(word1.length()-i);
                char str=word1.charAt(j);
                hm2.put(str,hm2.get(str)-1);
                if(hm1.getOrDefault(str,0)>hm2.getOrDefault(str,0)){
                    j++;
                    break;
                }
                j++;
            } 
        }
        return ans;
    }
}