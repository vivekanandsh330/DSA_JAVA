class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int minsofar=prices[0];
        for(int i=1;i<prices.length;i++){
            minsofar=Math.min(minsofar,prices[i]);
            ans=Math.max(ans,prices[i]-minsofar);
        }
        return ans;
    }
}