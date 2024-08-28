class Solution {

    boolean isSubIsland(int[][] grid1, int[][] grid2,int i,int j){
        if(i<0 || i>=grid1.length || j<0 || j>=grid1[0].length){
            return true;
        }
        if(grid2[i][j] != 1){
            return true;
        }
        grid2[i][j] =-1;

        boolean ans=(grid1[i][j] == 1);
        ans=ans& isSubIsland(grid1,grid2,i+1,j);
        ans=ans& isSubIsland(grid1,grid2,i-1,j);
        ans=ans& isSubIsland(grid1,grid2,i,j-1);
        ans=ans& isSubIsland(grid1,grid2,i,j+1);
        return ans;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n=grid2.length;
        int m=grid2[0].length;
        int subIsland=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid2[i][j] == 1 && isSubIsland(grid1,grid2,i,j)){
                    subIsland++;
                }
            }
        }
        return subIsland;
    }
}