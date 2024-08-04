class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Integer> prefixsum=new ArrayList<>();
        int k=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
               sum+=nums[j];
               prefixsum.add(sum);
            }
        }
        Collections.sort(prefixsum);
        int ans=0;
        int mod=(int)1e9+7;
        for(int i=left-1;i<right;i++){
            ans =(ans+prefixsum.get(i))%mod;
        }
        return ans;
    }
}