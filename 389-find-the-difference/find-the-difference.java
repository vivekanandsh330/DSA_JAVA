class Solution {
    public char findTheDifference(String s, String t) {
        char ans='0';
        for(char ch:s.toCharArray()){
            ans ^=ch;
        }
        for(char ch1:t.toCharArray()){
            ans ^=ch1;
        }
        ans ^='0';
        return ans;
    }
}