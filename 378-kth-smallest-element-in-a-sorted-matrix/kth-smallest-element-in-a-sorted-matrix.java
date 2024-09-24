class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int m=matrix[0].length;
        int l=matrix[0][0];
        int h=matrix[n-1][m-1];
        while(l<h){
            int mid=l+(h-l)/2;
            int cnt= iscnt(matrix,mid);
            if(cnt<k){
                l=mid+1;
            }
            else{
                h=mid;
            }
        }
        return l;
    }
    int iscnt(int[][]matrix,int target){
        int n=matrix.length,i=n-1,j=0;
        int cou=0;
        while(i>=0 && j<n){
            if(matrix[i][j] > target){
                i--;
            }
            else{
                cou = cou+i+1;
                j++;
            }
        }
        return cou;
    }
}