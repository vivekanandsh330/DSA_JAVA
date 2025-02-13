class Solution {
    public int minOperations(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(long i:nums){
            pq.add(i);
        }
        int count=0;
        while(pq.size()>1 && pq.peek()<k){
            long min=pq.poll();
            long max=pq.poll();
            long remove= min*2+max;
            pq.add(remove);
            count++;
        }
        return pq.peek()>=k ? count:-1;
    }
}