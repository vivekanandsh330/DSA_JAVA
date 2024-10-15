class Solution {
    public int minSwaps(String s) {
        Stack<Character> st=new Stack<>();
        int c=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch == '['){
                st.push(ch);
            }
            else{
                if(!st.isEmpty()){
                    st.pop();
                }
                else{
                    c++;
                }
            }
        }   
        return (c+1)/2;  
    }
}