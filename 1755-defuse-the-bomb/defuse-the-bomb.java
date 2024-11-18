class Solution {
    public int[] decrypt(int[] code, int k) {
        int n=code.length;
        int ans[]=new int[n];
        if(k == 0){
            return new int[n];
        }
        for(int i=0;i<n;i++){
            int currsum=0;
            for(int j=1;j<=Math.abs(k);j++){
                if(k>0){
                    currsum+=code[(i+j)%n];
                    ans[i]=currsum;
                }
            }
        }
        if(k<0){
            for(int i=0;i<n;i++){
                int currsum=0;
                for(int j=1;j<=Math.abs(k);j++){
                    currsum+=code[(i-j+n)%n];
                    ans[i]=currsum;
                }
            }
        }
        return ans;
    }
}