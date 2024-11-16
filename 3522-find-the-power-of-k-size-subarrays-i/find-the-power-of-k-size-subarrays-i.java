class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int ans[]=new int[nums.length-k+1];
        int i=0;
        int j=0;
        int idx=0;
        while(j<nums.length){
            if(j-i+1 == k){
                boolean flag=true;
                for(int m=i;m<j;m++){
                    if(nums[m]+1 != nums[m+1]){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    ans[idx]=nums[j];
                }else{
                    ans[idx]=-1;
                }
                idx++;
                i++;
            }
            j++;
        }
        return ans;
    }
}