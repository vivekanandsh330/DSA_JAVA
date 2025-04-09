class Solution {
    int n;
    int m;
    void dfs(char [][] grid,int i,int j){
        if(i<0 || i>=n|| j<0 || j>=m || grid[i][j] != '1'){
            return;
        }
        grid[i][j] ='$';

        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);

    }
    public int numIslands(char[][] grid) {
        n=grid.length;
        m=grid[0].length;
        int island=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] =='1'){
                    dfs(grid,i,j);
                    island++;
                }
            }
        }
        return island;
    }
}