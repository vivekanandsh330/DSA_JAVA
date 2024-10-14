class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int num:nums){
            pq.add(num);
        }
        long ans=0;
        while(k-->0){
            int max=pq.poll();
                ans+=max;
                max=(int)Math.ceil(max/3.0);
                pq.add(max);
        }
        return ans;
    }
}