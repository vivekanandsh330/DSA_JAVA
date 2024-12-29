class Solution {
    int dp[][]=new int[1001][1001];
    int n;
    int m;
    int mod=(int) 1e9+7;
    int solve(int i,int j,String target,int[][] fre){
        if(i == n){
            return 1;
        }
        if(j == m ){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j]; 
        }
        int nottaken=solve(i,j+1,target,fre)%mod;
        long taken=((long)fre[target.charAt(i)-'a'][j]*solve(i+1,j+1,target,fre))%mod;
        return dp[i][j] =(int)(nottaken+taken)%mod;
    }
    public int numWays(String[] words, String target) {
        n=target.length();
        m=words[0].length();
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        int fre[][]=new int[26][m];

        for(int i=0;i<m;i++){
            for(String word:words){
                char ch=word.charAt(i);
                fre[ch-'a'][i]++;
            }
        }
        return solve(0,0,target,fre);
    }
}