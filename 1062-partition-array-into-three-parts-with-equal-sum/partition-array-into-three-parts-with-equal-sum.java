class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int tsum=0;
        for(int num:arr){
            tsum+=num;
        }
        if(tsum % 3 != 0){
            return false;
        }
        int targets=tsum/3;
        int currs=0;
        int count=0;
        for(int num: arr){
            currs+=num;
            if(currs == targets){
                count++;
                currs=0;
            }
        }
        return count>=3;
    }
}