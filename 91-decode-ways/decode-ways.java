class Solution {
    int n;
    int dp[];
    int solve(String s,int idx){
        if(idx == n){
            return 1;
        }
        if(s.charAt(idx) == '0'){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int ith_plus1=solve(s,idx+1);
        int ith_plush2=0;
        if(idx+1<n){
        if(s.charAt(idx) == '1'|| (s.charAt(idx) == '2' && s.charAt(idx+1)<='6')){
        ith_plush2=solve(s,idx+2);
        }
        }
        return dp[idx]=ith_plus1+ith_plush2;
    }
    public int numDecodings(String s) {
        n=s.length();
        dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(s,0);
    }
}