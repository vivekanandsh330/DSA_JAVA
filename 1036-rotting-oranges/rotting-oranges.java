class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q=new ArrayDeque<>();
        int vis[][]=new int[n][m];
        int fo=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j,0});
                    vis[i][j]=2;
                }
                else if(grid[i][j] == 1){
                    fo++;
                }
                else{
                    vis[i][j]=0;
                }
            }
        }
        int cn=0;
        int t=0;
        int dirr[]={-1,0,+1,0};
        int dirc[]={0,1,0,-1};
        while(!q.isEmpty()){
            int num[]=q.poll();
            int r=num[0];
            int c=num[1];
            int v=num[2];
            t= Math.max(t,v);
            for(int i=0;i<4;i++){
                int nr=r+dirr[i];
                int nc=c+dirc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m &&
                grid[nr][nc] == 1 && vis[nr][nc] != 2){
                    q.add(new int[]{nr,nc,v+1});
                    vis[nr][nc]=2;
                    cn++;
                }
            }
        }
        if(fo != cn){
            return -1;
        }
        return t;
    }
}