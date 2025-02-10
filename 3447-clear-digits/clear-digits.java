class Solution {
    public String clearDigits(String s) {
        Stack<Character> st =new Stack<>();
        int n=s.length();

        for(int i=0;i<n;i++){
            if(Character.isDigit(s.charAt(i)) && !st.isEmpty()){
                st.pop();
            }
            else{
            st.push(s.charAt(i));
            }
        }
        StringBuilder ans=new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}