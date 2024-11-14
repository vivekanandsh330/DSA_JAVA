class Solution {
    boolean possibletodis(int mid,int []quantities,int shop){
        for(int quan:quantities){
            shop -=(quan+mid-1)/mid;
            if(shop<0){
                return false;
            }
        }
            return true;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int l=1;
        int r=Arrays.stream(quantities).max().getAsInt();
        int ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(possibletodis(mid,quantities,n)){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}