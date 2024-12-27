class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n=values.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> Integer.compare(b,a));
        pq.add(values[0]+0);
        int ans=0;
        for(int j=1;j<n;j++){
            int x=values[j]-j;
            int y=pq.peek();
            ans =Math.max(ans,x+y);
            pq.add(values[j]+j);
        }
        return ans;
    }
}