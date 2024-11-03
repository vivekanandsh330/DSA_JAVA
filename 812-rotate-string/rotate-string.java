class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        StringBuilder str=new StringBuilder(s);
        str=str.append(str);
        return (str.indexOf(goal) != -1);
    }
}