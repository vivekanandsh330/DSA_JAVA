class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0 || n == Integer.MIN_VALUE){
            return false;
        }
        boolean setBitCount=false;;
        for(int i=0;i<32;i++){
        if(((n>>i)&1)==1){
            if(setBitCount){
            return false;
            }
            setBitCount = true;
        }
    }
     return true;
}
}