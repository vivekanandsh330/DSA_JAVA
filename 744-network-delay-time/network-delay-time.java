class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,List<int[]>> adj=new HashMap<>();
        for(int time[]:times){
            int u=time[0], v=time[1],w=time[2];
            adj.computeIfAbsent(u,k1->new ArrayList<>()).add(new int[]{v,w});
        }
        int ans[]=new int[n+1];
        Arrays.fill(ans,Integer.MAX_VALUE);
        PriorityQueue<int []> pq=new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));
        ans[k]=0;
        pq.add(new int[]{0,k});
        while(!pq.isEmpty()){
            int poll[]=pq.poll();
            int d=poll[0];
            int node=poll[1];

            for(int neig[]: adj.getOrDefault(node,new ArrayList<>())){
                int adjnode=neig[0];
                int w=neig[1];
                if(d+w< ans[adjnode]){
                    ans[adjnode]=d+w;
                    pq.add(new int[]{ans[adjnode],adjnode});
                }
            }
        }
        int res=0;
        for(int i=1;i<=n;i++){
            if(ans[i] > res){
                res=ans[i];
            }
        }

        return res == Integer.MAX_VALUE ? -1:res;


    }
}