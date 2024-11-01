class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb=new StringBuilder();
        char prev=' ';
        int c=0;
        for(char ch: s.toCharArray()){
            c=(ch==prev)? ++c:1;
            if(c<3){
                sb.append(ch);
            }
            prev=ch;
        }
        return sb.toString();
    }
}