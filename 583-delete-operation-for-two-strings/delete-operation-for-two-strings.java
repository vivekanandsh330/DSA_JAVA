class Solution {
    int n;
    int m;
    int dp[][];
    int solve(String word1, String word2,int i1,int i2){
        if(i1<0 || i2<0){
            return 0;
        }
        if(dp[i1][i2] != -1){
            return dp[i1][i2];
        }
        if(word1.charAt(i1) == word2.charAt(i2)){
            return dp[i1][i2]= 1+solve(word1,word2,i1-1,i2-1);
        }
        return dp[i1][i2]= Math.max(solve(word1,word2,i1-1,i2),solve(word1,word2,i1,i2-1));
    }
    public int minDistance(String word1, String word2) {
        n=word1.length();
        m=word2.length();
        dp=new int[n+1][m+1];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        int lcs=solve(word1,word2,n-1,m-1);
        return n+m-2*(lcs);
    }
}