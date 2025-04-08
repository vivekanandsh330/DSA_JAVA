class Solution {
        boolean isSafe(int x,int y,int n,int m){
            return x>=0 && x<n && y>=0 && y<m;
        }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(n == 0 || m== 0 || grid[0][0] != 0){
            return -1;
        }
        int directions[][]={{1,1},{-1,-1},{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1}};
        Queue<int[]> q=new ArrayDeque<>();
        q.add(new int[]{0,0});
        grid[0][0]=1;
        int level=0;
        while(!q.isEmpty()){
            int s=q.size();
            while(s-->0){
                int poll[]=q.poll();
                int r=poll[0];
                int c=poll[1];
                if(r == n-1 && c== m-1){
                    return level+1;
                }

                for(int dir[]:directions){
                    int nx=r+dir[0];
                    int ny=c+dir[1];
                    if(isSafe(nx,ny,n,m) && grid[nx][ny] == 0){
                        q.add(new int[]{nx,ny});
                        grid[nx][ny]=1;
                    }

                }

            }
            level++;
        }
        return -1;
    }
}