class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int total=n*m;
        k=k%total;
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> subans=new ArrayList<>();
            for(int j=0;j<m;j++){
                int fi=flatindex(i,j,m,k,total);
                subans.add(grid[fi/m][fi%m]);
            }
            ans.add(subans);
        }
        return ans;
    }
    int flatindex(int i,int j,int col,int k,int total){
        int idx=(i*col+j+total-k)%total;
        return idx;
    }
}