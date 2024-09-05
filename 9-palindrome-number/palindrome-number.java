class Solution {
    public boolean isPalindrome(int n) {
        int temp=n;
        int revn=0;
        while(n >0){
            int ld=n%10;
            revn=(revn*10)+ld;
            n=n/10;
        }
        if(revn == temp){
            return true;
        }
        return false;   
    }
}