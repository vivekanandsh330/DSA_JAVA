class Solution {
    public int minimumDeletions(String s) {
        int bCount=0;
        int delReq=0;
        for(char ch : s.toCharArray()){
            if(ch == 'b'){
                bCount++;
            }
            else{
                delReq= Math.min(delReq+1,bCount);
            }
        }
        return delReq;   
    }
}