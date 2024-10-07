class Solution {
    public int minLength(String s) {
        Stack<Character> st=new Stack<>();
        int i=0;
        while(i<s.length()){
            char ch=s.charAt(i);
            if(st.isEmpty()){
                st.push(ch);
                i++;
                continue;
            }
            if(ch == 'B' && st.peek()=='A'){
                st.pop();
            }
            else if(ch == 'D' && st.peek() == 'C'){
                st.pop();
            }
            else{
                st.push(ch);
            }
            i++;
        }
        return st.size();
    }
}