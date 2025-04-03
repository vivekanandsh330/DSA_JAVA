class Solution {
    int n;

    void bfs(Map<Integer,List<Integer>> adj,boolean vis[],int u){
        Queue<Integer> q=new ArrayDeque<>();
        q.add(u);
        vis[u]=true;
        while(!q.isEmpty()){
        int u1=q.poll();
        for(int v:adj.getOrDefault(u1,new ArrayList<>())){
            if(!vis[v]){
                // q.add(v);
                bfs(adj,vis,v);
            }
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
                bfs(adj,vis,i);
                count++;
            }
        }
        return count;
    }
}