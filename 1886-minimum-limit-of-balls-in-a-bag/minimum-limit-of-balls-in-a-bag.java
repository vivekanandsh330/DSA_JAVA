class Solution {
    boolean isPossible(int []nums,int maxOperations,int mid){
        int totalops=0;
        for(int num:nums){
            int ops=num/mid;
            if(num % mid == 0){
                ops -= 1;
            }
            totalops += ops;
        }
        return totalops <= maxOperations;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int l=1;
        int r=Arrays.stream(nums).max().getAsInt();
        int ans=r;
        while(l<=r){
            int mid= l+(r-l)/2;
            if(isPossible(nums,maxOperations,mid)== true){
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