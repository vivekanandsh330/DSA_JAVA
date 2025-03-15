class Solution {

    boolean isSolve(int nums[],int k,int mid){
        int house=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<= mid){
                house++;
                i++;
            }
        }
        return house>=k;
    }
    public int minCapability(int[] nums, int k) {
        int n=nums.length;
        int l=Arrays.stream(nums).min().getAsInt();
        int r=Arrays.stream(nums).max().getAsInt();

        int ans=r;
        while(l<=r){
            int mid=l+(r-l)/2;

            if(isSolve(nums,k,mid) == true){
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