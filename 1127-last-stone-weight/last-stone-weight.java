class Solution {
    public int lastStoneWeight(int[] stone) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> b-a);
        for(int i:stone){
            pq.add(i);
        }
        while(pq.size()>1){
            int a=pq.poll();
            int b=pq.poll();
            if(a !=b){
                pq.add(Math.abs(a-b));
            }
        }
        return pq.isEmpty()? 0:pq.peek();
    }
}