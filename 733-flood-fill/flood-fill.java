class Solution {
    void dfs(int r,int c,int[][] ans,int[][] image,int nc,int delrow[],int delcol[],int ic){
        ans[r][c] =nc;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){
            int nrow=r+delrow[i];
            int ncol=c+delcol[i];
            if(nrow>=0&& nrow<n && ncol >=0&& ncol<m && image[nrow][ncol] == ic && 
            image[nrow][ncol] != nc ){
                dfs(nrow,ncol,ans,image,nc,delrow,delcol,ic);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ic=image[sr][sc];
        int ans[][]=image;
        int delrow[]={-1,0,+1,0};
        int delcol[]={0,+1,0,-1};
        dfs(sr,sc,ans,image,color,delrow,delcol,ic);
        return ans;
    }
}