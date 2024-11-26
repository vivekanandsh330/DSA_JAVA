class Solution {
    public int findChampion(int[][] grid) {
        int camp=-1;       
        int max=Integer.MIN_VALUE;
        int ans[]=new int[grid.length];
        for(int i=0;i<grid.length;i++){
            int ccount=0;
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    ccount++;
                    ans[i]=ccount;
                   
                }
            }
           
        }
         System.out.println(Arrays.toString(ans));
        int champ=-1;
        int c=0;
        for(int i=0;i<grid.length;i++){
            if(ans[i]>c){
                c=ans[i];
                champ=i;
            }
        }
        return champ;
    }
}