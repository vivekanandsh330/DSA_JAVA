class Solution {
    public int minOperations(int[] nums, int x) {

        int n=nums.length;
        int sum=0;
        Map<Integer,Integer> hm=new HashMap<>();
        hm.put(0,-1);
        int j=0;

        for(int num:nums ){
            sum += num;
            hm.put(sum,j);
            j++;
        }
        if(sum<x){
            return -1;
        }
        int remS=sum-x;
        int lsa=Integer.MIN_VALUE;
        sum=0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            int frs=sum-remS;
            if(hm.containsKey(frs)){
                int idx=hm.get(frs);
                lsa=Math.max(lsa,i-idx);
            }
        }
        return  lsa == Integer.MIN_VALUE ? -1 : n-lsa;
        
    }
}