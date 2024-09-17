class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=0;
        if(n != 0){
            m=matrix[0].length;
        }
        int i=n-1;
        int j=0;
        while(i>=0 && j<m){
            int curr=matrix[i][j];
            if(curr == target ){
                return true;
            }
            else if(curr> target){
                i--;
            }
            else{
                j++;
            }
        }
        return false;
    }
}