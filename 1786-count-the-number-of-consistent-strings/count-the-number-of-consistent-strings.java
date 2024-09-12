class Solution {
    public int countConsistentStrings(String allowed, String[] words) {

        Set<Character> st=new HashSet<>();
        for(char ch: allowed.toCharArray()){
            st.add(ch);
        }
        int count=0;
        for(String word:words){
            boolean flag=true;
            for(char c: word.toCharArray()){
                if(!st.contains(c)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                count++;
            }
        }
        return count;
    }
}