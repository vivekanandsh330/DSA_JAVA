class Solution {
    public int minGroups(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int []interval:intervals){
            int s=interval[0];
            int e=interval[1];

            if(!pq.isEmpty() && s > pq.peek()){
                pq.poll();
            }
            pq.add(e);
        }
        return pq.size();
    }
}