class Solution {
    public int[] decrypt(int[] code, int k) {
        int n=code.length;
        int ans[]=new int[n];
        if(k == 0){
            return new int[n];
        }
        int i=-1;
        int j=-1;
        if(k >0){
            i=1;
            j=k;
        }
        else {
            i=n-Math.abs(k);
            j=n-1;
        }
        int currsum=0;
        for(int p=i;p<=j;p++){
            currsum+=code[p];
        }
        for(int m=0;m<n;m++){
            ans[m]=currsum;
            currsum -= code[i%n];
            i++;
            currsum += code[(j+1)%n];
            j++;
        }
        return ans;
    }
}