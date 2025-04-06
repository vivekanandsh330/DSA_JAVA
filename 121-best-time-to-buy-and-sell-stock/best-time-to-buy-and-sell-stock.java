class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int minsofar=prices[0];
        int ans=0;
        for(int i=1;i<n;i++){
            minsofar=Math.min(minsofar,prices[i]);
            ans=Math.max(ans,prices[i]-minsofar);
        }
        return ans;
    }
}