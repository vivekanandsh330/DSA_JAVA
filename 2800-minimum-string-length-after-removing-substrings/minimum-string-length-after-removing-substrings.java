class Solution {
    public int minLength(String e) {
        StringBuilder s=new StringBuilder(e);
        int i=0;
        int j=1;
        while(j<s.length()){
            if(i<0){
                i++;
                s.setCharAt(i,s.charAt(j));
            }
            else if((s.charAt(j) == 'B' && s.charAt(i) == 'A')||(s.charAt(j) == 'D' && s.charAt(i)== 'C')){
                i--;
            }
            else {
                i++;
                s.setCharAt(i,s.charAt(j));
            }
            j++;
        }
        return i+1;
    }
}