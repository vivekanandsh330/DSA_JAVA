class Solution {
    int dp[][];
    int solve(String s,int l,int r,int n){
        if(l == r){
            return 1;
        }
        if(l>r){
            return 0;
        }
        if(dp[l][r] != -1){
            return dp[l][r];
        }

        if(s.charAt(l) == s.charAt(r)){
            return dp[l][r]=2+solve(s,l+1,r-1,n);
        }
        return dp[l][r]=Math.max(solve(s,l+1,r,n),solve(s,l,r-1,n));
    }
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        if(n == 0 || s== null){
            return 0;
        }
        dp=new int[n+1][n+1];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        return solve(s,0,n-1,n);
    }
}