class Solution {
    public int maximumWealth(int[][] accounts) {
        int n=accounts.length;
        int m=accounts[0].length;
        int maxA=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<m;j++){
                sum+=accounts[i][j];
                if(sum> maxA){
                    maxA=sum;
                }
            }
        }
        return maxA;
    }
}