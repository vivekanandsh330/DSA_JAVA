class Solution {
    void update(int num,int []vec,int val){
        for(int i=0;i<32;i++){
        if(((num>>i)&1) !=0){
            vec[i] += val;
        }
        }
    }
    int finddecimaltoBinary(int []vec){
        int nm=0;
        for(int i=0;i<32;i++){
            if(vec[i]>0){
                nm |= (1<<i);
            }
        }
        return nm;
    }
    public int minimumSubarrayLength(int[] nums, int k) {
       int n=nums.length;
       int sum=Integer.MAX_VALUE;
       int i=0;
       int j=0;
       int vis[]=new int[32];
       while(j<n){
        update(nums[j],vis,1);
        while(i<=j && finddecimaltoBinary(vis)>=k){
            sum =Math.min(sum,j-i+1);
            update(nums[i],vis,-1);
            i++;
        }
        j++;
       }
       return sum == Integer.MAX_VALUE ? -1 : sum;
        
    }
}