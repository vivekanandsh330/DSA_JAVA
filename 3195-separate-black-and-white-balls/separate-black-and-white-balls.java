class Solution {
    public long minimumSteps(String s) {
        long no1 = 0;
        long swap=0;
        for (int i = 0; i < s.length(); i++) {
           if(s.charAt(i) == '1'){
            no1++;
           }
           if(s.charAt(i) == '0'){
            swap+=no1;
           }
        }
        return swap;
    }
}