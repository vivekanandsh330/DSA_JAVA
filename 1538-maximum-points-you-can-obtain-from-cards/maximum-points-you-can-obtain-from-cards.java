class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int ans=0;
        int n=cardPoints.length;
        int tsum=0;
        for(int num: cardPoints){
            tsum+=num;
        }
        if(n-k == 0){
            return tsum;
        }

        int i=0;
        int j=0;
        int csum=0;
        while(j<n){
             System.out.println(csum);
            csum += cardPoints[j];
            if(j-i == n-k-1){
               // System.out.println(tsum-csum);
                ans= Math.max(ans,tsum-csum);
                i++;
                csum -= cardPoints[i-1];
               // System.out.println(csum);
            
            }
            // System.out.println(csum);
            j++;
        }
        return ans;

    }
}