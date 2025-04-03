class Solution {
    int n;

    void dfs(Map<Integer,List<Integer>> adj,boolean vis[],int u){
        vis[u]=true;
        for(int v:adj.getOrDefault(u,new ArrayList<>())){
            if(!vis[v]){
                dfs(adj,vis,v);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        n=isConnected.length;
        
        Map<Integer,List<Integer>> adj=new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj.computeIfAbsent(i,k->new ArrayList<>()).add(j);
                    adj.computeIfAbsent(j,k->new ArrayList<>()).add(i);
                }
            }
        }

        int count=0;
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(adj,vis,i);
                count++;
            }
        }
        return count;
    }
}