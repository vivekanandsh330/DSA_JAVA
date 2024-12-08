class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events,(a,b)-> Integer.compare(a[0],b[0]));

        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)-> Integer.compare(a[1],b[1]));

        int ans=0;
        int maxse=0;

        for(int event[]:events){
            int s=event[0];
            int e=event[1];
            int v=event[2];

            while(!pq.isEmpty() && pq.peek()[1]<s){
                int fe[]=pq.poll();
                maxse=Math.max(maxse,fe[2]);
            }
            ans=Math.max(ans,v+maxse);
            pq.add(event);
            ans=Math.max(ans,v);
        }
        return ans;
    }
}