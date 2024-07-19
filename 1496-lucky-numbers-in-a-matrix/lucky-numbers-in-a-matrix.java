class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int rMinMax=Integer.MIN_VALUE;
        int cMaxMin=Integer.MAX_VALUE;
    
        for(int i=0;i<n;i++){
            int rMin=Integer.MAX_VALUE;
           for(int j=0;j<m;j++){
              rMin=Math.min(rMin,matrix[i][j]);
           }
           rMinMax=Math.max(rMinMax,rMin);
        }

        for(int j=0;j<m;j++){
            int cMax=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
               cMax=Math.max(cMax,matrix[i][j]);
            }
            cMaxMin=Math.min(cMaxMin,cMax);
        }
        List<Integer> ans=new ArrayList<>();
       if(rMinMax == cMaxMin){
          ans.add(rMinMax);
       }
       return ans;
    }
}