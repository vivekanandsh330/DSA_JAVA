class Solution {
    public int[][] merge(int[][] intervals) {
       PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
       for(int interval[]:intervals){
        pq.add(interval);
       }

       List<int []> merge=new ArrayList<>();

       while(!pq.isEmpty()){
        int curr[]=pq.poll();
        if(merge.isEmpty() || merge.get(merge.size()-1)[1]<curr[0] ){
            merge.add(curr);
        }else {
            merge.get(merge.size()-1)[1]=Math.max(merge.get(merge.size()-1)[1],curr[1]);
        }

       }
       return merge.toArray(new int[merge.size()-1][]);
    }
}