class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int ans[]=new int[arr.length];
        ans[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            ans[i]=ans[i-1]^arr[i];
        }
        int res[]=new int[queries.length];
        int idx=0;
        for(int j[]:queries){
            int l=j[0];
            int r=j[1];
            int xorval=ans[r]^((l==0)? 0:ans[l-1]);
            res[idx++]=xorval;
        }
        return res;   
    }
}