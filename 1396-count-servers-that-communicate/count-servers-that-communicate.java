class Solution {
    public int countServers(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int prerow[]=new int[n];
        int precol[]=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    prerow[i]+=1;
                    precol[j]+=1;
                }
            }
        }

        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && (prerow[i] >1 || precol[j] >1)){
                    ans++;
                }
            }
        }
        return ans;
    }
}