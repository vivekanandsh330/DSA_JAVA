class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer,List<Pair<Integer,Double>>>hm=new HashMap<>();

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            double prob=succProb[i];
            hm.computeIfAbsent(u,k->new ArrayList<>()).add(new Pair<>(v,prob));
            hm.computeIfAbsent(v,k->new ArrayList<>()).add(new Pair<>(u,prob));
        }

        double ans[]=new double[n];
        ans[start_node]=1d;

        PriorityQueue<Pair<Double,Integer>> pq=new PriorityQueue<>((p1,p2)-> p2.getKey().compareTo(p1.getKey()));
        pq.add(new Pair<>(1d,start_node));

        while(!pq.isEmpty()){
            Pair<Double,Integer> curr=pq.poll();
            double currp=curr.getKey();
            int currn=curr.getValue();

            if(currn == end_node){
                return currp;
            }
            for(Pair<Integer,Double> neigh:hm.getOrDefault(currn,new ArrayList<>())){
                int nexn=neigh.getKey();
                double nexp=neigh.getValue();

                if(currp*nexp > ans[nexn]){
                    ans[nexn]=currp*nexp;
                    pq.add(new Pair<>(ans[nexn],nexn));
                }

            }
        }
        return 0d;
    }
}