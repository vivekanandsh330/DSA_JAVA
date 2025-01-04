class Solution {
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        Set<Character> st=new HashSet<>();
        for(char ch :s.toCharArray() ){
            st.add(ch);
        }
        int ans=0;
        for(char ch:st){
        int leftch=-1;
        int rightch=-1;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == ch){
                if(leftch == -1){
                    leftch = i;
                }
                rightch=i;
            }
        }
      
        Set<Character> stans=new HashSet<>();

        for(int i=leftch+1;i<=rightch-1;i++){
            stans.add(s.charAt(i));
        }
        ans +=stans.size();
           
        }
        return ans;
    }
}