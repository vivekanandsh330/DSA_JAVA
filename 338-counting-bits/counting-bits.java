class Solution {
    public int[] countBits(int n) {
        int ans[]=new int[n+1];
        for(int i=0;i<n+1;i++){
            ans[i]=count(i);
        }
        return ans;
    }
    int count(int j){
        int count=0;
        for(int i=0;i<32;i++){
            if(((j>>i)&1)==1){
                count++;
            }
        }
        return count;
    }
}