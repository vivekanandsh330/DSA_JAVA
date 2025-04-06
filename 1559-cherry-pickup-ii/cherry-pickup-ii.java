class Solution {
    int n;
    int m;
    int dp[][][];
    int solve(int [][] grid,int r,int c1,int c2){
        if(r>=n){
            return 0;
        }
        int cherry=grid[r][c1];//only one can take the cherry
        if(c1 != c2){
            cherry +=grid[r][c2];
        }
        if(dp[r][c1][c2] != -1){
            return dp[r][c1][c2];
        }
        int ans=0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int newr=r+1;
                int new_c1=c1+i;
                int new_c2=c2+j;
                if(new_c1>=0 && new_c1<m && new_c2>=0 && new_c2<m){
                    ans=Math.max(ans,solve(grid,newr,new_c1,new_c2));
                }
            }
        }
        return dp[r][c1][c2]=cherry+ans;

    }
    public int cherryPickup(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        dp=new int[n+1][m+1][m+1];
        for(int i[][]:dp){
            for(int j[]:i){
                Arrays.fill(j,-1);
            }
        }
        return solve(grid,0,0,m-1);
        
    }
}