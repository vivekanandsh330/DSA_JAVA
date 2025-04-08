class Solution {
    boolean dfs(Map<Integer,List<Integer>> adj,int curr,int[]color,int currcolor){
        color[curr]=currcolor;
        for(int v:adj.getOrDefault(curr,new ArrayList<>())){
            if(color[v]==color[curr]){
                return false;
            }
            if(color[v] == -1){
                int newcolor=1-currcolor;
                if(dfs(adj,v,color,newcolor) == false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int i=0;i<n;i++){
            adj.put(i,new ArrayList<>());
            for(int j:graph[i]){
                adj.get(i).add(j);
            }
        }
        int color[]=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i] == -1 ){
                if(dfs(adj,i,color,1)== false){
                    return false;
                }
            }
        }
        return true;
    }
}