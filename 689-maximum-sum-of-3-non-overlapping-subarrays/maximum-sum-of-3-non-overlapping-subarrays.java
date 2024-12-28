class Solution {
    int dp[][] =new int[20001][4];
    int helper(int[] subarray,int count,int i,int k){
        if(count == 0){
            return 0;
        }
        if(i>= subarray.length){
            return Integer.MIN_VALUE;
        }

        if(dp[i][count] != -1){
            return dp[i][count]; 
        }

        int take=subarray[i]+helper(subarray,count-1,i+k,k);
        int nottake=helper(subarray,count,i+1,k);

        return dp[i][count]=Math.max(take,nottake);
    }

    void solve(int[] subarray,int count,int i,List<Integer> ans,int k){
        if(count == 0){
            return;
        }
        if(i>=subarray.length){
            return;
        }

        int take=subarray[i]+helper(subarray,count-1,i+k,k);
        int nottake=helper(subarray,count,i+1,k);
        if(take>=nottake){
            ans.add(i);
            solve(subarray,count-1,i+k,ans,k);
        }else{
            solve(subarray,count,i+1,ans,k);
        }

    }
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {

        for(int [] row: dp){
            Arrays.fill(row,-1);
        }
        int n=nums.length-k+1;
        int subarray[]=new int[n];
        int i=0;
        int j=0;
        int windowsum=0;
        while(j<nums.length){
            windowsum +=nums[j];
            if(j-i+1 == k){
                subarray[i]=windowsum;
                windowsum -= nums[i];
                i++;
            }
            j++;
        }
        List<Integer> ans=new ArrayList<>();
        solve(subarray,3,0,ans,k);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}