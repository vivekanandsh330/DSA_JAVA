class Solution {
    int n;
    int q;
    boolean allzero(int nums[],int[][] queries,int k){
        int diff[]=new int[n];

        for(int i=0;i<=k;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            int v=queries[i][2];

            diff[l] += v;
            if(r+1<n){
            diff[r+1] -= v;
            }  
        }

        int cumsum=0;
        for(int i=0;i<n;i++){
            cumsum += diff[i];
            diff[i]=cumsum;

            if(nums[i] -diff[i] >0){
                return false;
            }
        }
        return true;

    }
    public int minZeroArray(int[] nums, int[][] queries) {
        n=nums.length;
        q=queries.length;
      
        if(Arrays.stream(nums).allMatch(x->x==0)){
            return 0;
        }

        int l=0;
        int r=q-1;
        int k=-1;

        while(l<=r){
            int mid=l+(r-l)/2;

            if(allzero(nums,queries,mid) == true){
                k=mid+1;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return k;
    }
}