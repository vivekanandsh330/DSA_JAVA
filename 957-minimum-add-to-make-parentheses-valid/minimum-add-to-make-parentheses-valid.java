class Solution {
    public int minAddToMakeValid(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();
        int c=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch == '('){
                st.push(ch);
            }
            else{
                if(st.isEmpty() || st.peek() == ')'){
                    st.push(ch);

                }else{
                    st.pop();
                }
            }
        }
        return st.size();
    }
}