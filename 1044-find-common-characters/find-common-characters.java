class Solution {
    public List<String> commonChars(String[] words) {
        int minfre[]=new int[26];
        Arrays.fill(minfre,Integer.MAX_VALUE);

        for(String word:words){
            int tempfre[]=new int[26];
            for(char ch:word.toCharArray()){
                tempfre[ch-'a']++;
            }
            for(int i=0;i<26;i++){
                minfre[i]=Math.min(minfre[i],tempfre[i]);
            }
        }
        List<String> ans=new ArrayList<>();
        for(int i=0;i<26;i++){
            for(int j=0;j<minfre[i];j++){
                ans.add(String.valueOf((char)(i+'a')));
            }
        }
        return ans; 
    }
}