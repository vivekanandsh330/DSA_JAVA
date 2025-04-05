class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int [][] idx=new int[n][2];
        for(int i=0;i<n;i++){
            idx[i]=new int[]{i,nums[i]};
        }
        Arrays.sort(idx,(a,b)-> Integer.compare(a[1],b[1]));
        int i=0;
        int j=n-1;
        int presum=0;
        Arrays.sort(nums);
        while(i<j){
            presum =idx[i][1]+idx[j][1];
            if(presum == target){
                return new int[]{idx[i][0],idx[j][0]};
            }
            else if(presum<target){
                i++;
            }
            else{
                j--;
            }
        }
        return new int[]{};
    }
}