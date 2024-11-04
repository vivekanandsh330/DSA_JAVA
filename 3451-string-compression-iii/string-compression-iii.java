class Solution {
    public String compressedString(String word) {
        int n=word.length();
        int i=0;
        StringBuilder sb=new StringBuilder();
        while(i<n){
            char ch=word.charAt(i);
            int count=0;
            while(i<n && count<9 && ch == word.charAt(i)){
                count++;
                i++;
            }
            sb.append(count).append(ch);
        }
        return sb.toString();
    }
}