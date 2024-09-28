class Solution {
    public long maximumTotalSum(int[] maxH) {
        int n=maxH.length;
        Arrays.sort(maxH);
        long sum=0;
        int lah=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            int currh=Math.min(maxH[i],lah-1);
            if(currh <1){
                return -1;
            }
            sum+=currh;
            lah =currh;
        }
        return sum;
    }
}