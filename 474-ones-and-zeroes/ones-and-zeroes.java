class Solution {
    int l;
    int dp[][][];
    int solve(String[] strs, int m, int n,int idx){
        if(idx == l){
            return 0;
        }
        if(dp[idx][m][n] != -1){
            return dp[idx][m][n];
        }
        int count[]=countOfZeroOne(strs[idx]);
        int zero=count[0];
        int one=count[1];
        int nottake=solve(strs,m,n,idx+1);
        int take=Integer.MIN_VALUE;
        if(m>=zero && n>=one){
            take=1+solve(strs,m-zero,n-one,idx+1);
        }
        return dp[idx][m][n]= Math.max(take,nottake);
    }
    int [] countOfZeroOne(String str){
        int zero=0;
        int one=0;
        for(char ch: str.toCharArray()){
            if(ch == '0'){
                zero++;
            }
            else{
                one++;
            }
        }
        return new int[]{zero,one};
    }
    public int findMaxForm(String[] strs, int m, int n) {
        l=strs.length;
        dp=new int[l+1][m+1][n+1];
        for(int i[][]:dp){
            for(int j[]:i){
                Arrays.fill(j,-1);
            }
        }
        return solve(strs,m,n,0);
    }
}