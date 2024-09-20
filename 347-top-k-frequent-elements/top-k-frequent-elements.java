class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int num: nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
       PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> (a[1]-b[1]));
       for(int i:hm.keySet()){
        pq.add(new int[]{i,hm.get(i)});
        if(pq.size()>k){
            pq.poll();
        }
       }
       int ans[]=new int[pq.size()];
       while(k>0){
        ans[k-1]=pq.poll()[0];
        k--;
       }
       return ans;
    }
}