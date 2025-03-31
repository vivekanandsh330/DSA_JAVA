class Solution {
    int dp[][];
    int solve(String text1, String text2,int idx1,int idx2){

        if(idx1<0 || idx2 <0){
            return 0;
        }
        if(dp[idx1][idx2] != -1){
            return dp[idx1][idx2];
        }


        if(text1.charAt(idx1) == text2.charAt(idx2)){
            return dp[idx1][idx2]=1+solve(text1,text2,idx1-1,idx2-1);
        }
        return dp[idx1][idx2]= Math.max(solve(text1,text2,idx1-1,idx2),solve(text1,text2,idx1,idx2-1));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1=text1.length();
        int n2=text2.length();
        dp=new int[n1+1][n2+1];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        return solve(text1,text2,n1-1,n2-1);
    }
}