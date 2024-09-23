class Solution {
    int dp[];
    int solve(int idx,String s,Set<String> st,int n){
        if(idx >=n){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int ans= 1+solve(idx+1,s,st,n);
        for(int j=idx;j<n;j++){
            String cs=s.substring(idx,j+1);
            if(st.contains(cs)){
                ans=Math.min(ans,solve(j+1,s,st,n));
            }
        }
        return  dp[idx]=ans;
    }
    public int minExtraChar(String s, String[] dict) {
        int n=s.length();
        dp=new int[51];
        Arrays.fill(dp,-1);
        Set<String> st=new HashSet<>(Arrays.asList(dict));
        return solve(0,s,st,n);
    }
}