class Solution {
   
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int island=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    island+=1;
                }
            }
        }
        return island;
    }
     void dfs(char ch[][],int i,int j){
        int n=ch.length;
        int m=ch[0].length;
        if(i<0 || i>=n || j<0 || j>=m || ch[i][j] != '1'){
            return;
        }
        ch[i][j] ='0';
        
        dfs(ch,i+1,j);
        dfs(ch,i-1,j);
        dfs(ch,i,j+1);
        dfs(ch,i,j-1);
    }
}
