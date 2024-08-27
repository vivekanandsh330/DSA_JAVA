class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
          
          Map<Integer,List<Pair<Integer,Double>>> graph=new HashMap<>();

          for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            double pathprob = succProb[i];
            graph.computeIfAbsent(u,k -> new ArrayList<>()).add(new Pair<>(v,pathprob));
            graph.computeIfAbsent(v,k -> new ArrayList<>()).add(new Pair<>(u,pathprob));
          }

          double ans[]=new double[n];
          ans[start_node]=1d;


          PriorityQueue<Pair<Double,Integer>> maxp=new PriorityQueue<>(
            (p1,p2)-> p2.getKey().compareTo(p1.getKey()));
            maxp.add(new Pair<>(1.0,start_node));

            while(!maxp.isEmpty()){

                Pair<Double,Integer> cur=maxp.poll();
                double curProb=cur.getKey();
                int curNode=cur.getValue();

                if(curNode == end_node){
                    return curProb;
                }

                for(Pair<Integer,Double> next: graph.getOrDefault(curNode,new ArrayList<>())){
                    int nextNode=next.getKey();
                    double nextProb=next.getValue();

                    if(curProb*nextProb > ans[nextNode]){
                        ans[nextNode]=curProb*nextProb;
                        maxp.add(new Pair<>(ans[nextNode],nextNode));
                    }
                }
            }

            return 0d;
            
    }
}