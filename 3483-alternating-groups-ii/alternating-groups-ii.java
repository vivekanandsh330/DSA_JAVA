class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n=colors.length;
        int N=n+k-1;
        int temp[]=new int[N];

        System.arraycopy(colors,0,temp,0,n);
        for(int i=0;i<k-1;i++){
            temp[n+i]=colors[i];
        }
        int i=0;
        int j=1;
        int ans=0;
        while(j<N){
            if(temp[j] == temp[j-1]){
                i=j;
                j++;
                continue;
            }
            if(j-i+1 == k){
                ans++;
                i++;
            }
            j++;
        }
        return ans;
    }
}