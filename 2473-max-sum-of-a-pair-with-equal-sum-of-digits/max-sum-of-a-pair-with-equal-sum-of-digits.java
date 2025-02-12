class Solution {
    public int maximumSum(int[] nums) {
         int n=nums.length;
         int maxsum=-1;
         HashMap<Integer,Integer> hm=new HashMap<>();
         for(int i=0;i<n;i++){
            int n1=nums[i];
            int ds=digitSum(n1);
            if(hm.containsKey(ds)){
                maxsum=Math.max(maxsum,n1+hm.get(ds));
            }
            hm.put(ds,Math.max(hm.getOrDefault(ds,0),nums[i]));
         }
         return maxsum;
    }
    int digitSum(int n){
        int sum=0;
        while(n != 0){
            sum += (n%10);
            n=n/10;
        }
        return sum;
    }
}