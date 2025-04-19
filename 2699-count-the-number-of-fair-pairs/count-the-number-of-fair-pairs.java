class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n=nums.length;
        long ans=0;
        for(int i=0;i<n;i++){
            int lidx=lowerBound(nums,i+1,n,lower-nums[i]);
            int x=lidx-1-i;
            int ridx=upperBound(nums,i+1,n,upper-nums[i]);
            int y=ridx-1-i;
            ans +=(y-x);
        }
        return ans;
    }

    int lowerBound(int[] nums,int s,int e,int t){
        while(s<e){
        int mid=s+(e-s)/2;
        if(nums[mid]<t){
            s=mid+1;
        }
        else{
            e=mid;
        }

        }
        return s;
    }

    int upperBound(int[] nums,int s,int e,int t){
        while(s<e){
            int mid=s+(e-s)/2;
            if(nums[mid]<=t){
                s=mid+1;
            }
            else{
                e=mid;
            }
        }
        return s;
    }
}