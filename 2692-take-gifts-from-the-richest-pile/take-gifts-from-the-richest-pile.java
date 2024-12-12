class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->(b-a));
        for(int num:gifts){
            pq.add(num);
        }
        long sum=0;
        while(k-->0){
            pq.add((int)Math.sqrt(pq.remove()));
        }
        while(pq.size()>0){
            sum+=pq.remove();
        }
        return sum;
    }
}