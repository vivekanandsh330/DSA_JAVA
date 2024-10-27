class Solution {
    public boolean checkValid(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        Set<Integer> hm=null;
        for(int i=0;i<n;i++){
            hm=new HashSet<>();
            for(int j=0;j<m;j++){
                 int el=matrix[i][j];
                if(hm.contains(el)){
                    return false;
                }
                else{
                    hm.add(el);
                }
            }
        }
        for(int i=0;i<m;i++){
            hm=new HashSet<>();
            for(int j=0;j<n;j++){
                int el=matrix[j][i];
                if(hm.contains(el)){
                    return false;
                }
                else{
                    hm.add(el);
                }
            }
        }
        return true;
    }
}