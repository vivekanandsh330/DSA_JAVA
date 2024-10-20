class Solution {
    char solveop(List<Character> val,char op){
        if(op == '!'){
            return val.get(0) == 't' ? 'f':'t';
        }
        if(op == '&'){
            for(char a:val){
                if(a == 'f'){
                    return 'f';
                }
            }
            return 't';
        }
        if(op == '|'){
            for(char r:val){
                if(r == 't'){
                    return 't';
                }
            }
            return 'f';
        }
        return 't';
    }
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st=new Stack<>();
        for(char ch: expression.toCharArray()){
            if(ch == ','){
                continue;
            }
            if(ch == ')'){
                List<Character> val=new ArrayList<>();
                while(st.peek() !='('){
                    val.add(st.pop());
                }
                st.pop();
                char op=st.pop();
                st.push(solveop(val,op));
            }else{
                st.push(ch);
            }
        }
        return st.peek() == 't';
    }
}