class Solution {
    boolean palindrome(String s,int i ,int j){
        if(i>=j){
            return true;
        }
        if(s.charAt(i) == s.charAt(j)){
            return palindrome(s,i+1,j-1);
        }
        return false;
    }
    public String longestPalindrome(String s) {
       int n=s.length();
       int maxlen=Integer.MIN_VALUE;
       int sp=0;
       for(int i=0;i<n;i++){
        for(int j=i;j<n;j++){
            if(palindrome(s,i,j) == true){
                if(j-i+1 >maxlen){
                    maxlen=j-i+1;
                    sp=i;
                }
            }
        }
       }
       return s.substring(sp,sp+maxlen);
    }
}