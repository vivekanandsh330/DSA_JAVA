class Solution {
    public String reverseParentheses(String s) {
        int n=s.length();
       Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == ')') 
            {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '(')
                {
                    sb.append(stack.pop());
                }
                stack.pop();
                for (char revCh : sb.toString().toCharArray()) 
                {
                    stack.push(revCh);
                }
            } 
            else 
            {
                stack.push(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        for (char ch : stack) 
        {
            result.append(ch);
        }
        return result.toString();
    }
}