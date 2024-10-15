class Solution {
    int M=(int)1e9+7;
    int rev(int num){
        int ans=0;
        while(num!=0){
        int rem=num%10;
        ans=(ans*10)+rem;
        num/=10;
        }
        return ans;
    }
    public int countNicePairs(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            nums[i]=nums[i]-rev(nums[i]);
        }
        Map<Integer,Integer> hm=new HashMap<>();
        int res=0;
        for(int i=0;i<n;i++){
            res=(int)(res+hm.getOrDefault(nums[i],0))%M;
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        return res;
    }
}