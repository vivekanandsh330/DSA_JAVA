class Solution {
    public int[][] highestPeak(int[][] isWater) {
         int n=isWater.length;
         int m=isWater[0].length;
         int height[][]=new int[n][m];

         Queue<int []> q=new LinkedList<>();

         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isWater[i][j] == 1){
                    q.offer(new int[]{i,j});
                    height[i][j]=0;
                }
                else{
                    height[i][j]=-1;
                }
            }
         }

         int [][] directions ={{0,1},{0,-1},{1,0},{-1,0}};

         while(!q.isEmpty()){
            int s=q.size();
            while(s -- >0){
                int []curr=q.poll();
                int i=curr[0];
                int j=curr[1];

                for(int []dir:directions){
                    int ni=i+dir[0];
                    int nj=j+dir[1];

                    if(ni>=0 && ni <n && nj >=0 && nj<m && height[ni][nj] == -1){
                        height[ni][nj]=height[i][j]+1;
                        q.offer(new int[]{ni,nj});
                    }
                }

            }


         }

         return height;


    }

}
