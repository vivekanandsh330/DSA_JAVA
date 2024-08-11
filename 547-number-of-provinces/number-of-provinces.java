class Solution {
    public int findCircleNum(int[][] isConnected) {
       ArrayList<ArrayList<Integer>> adjLis=new ArrayList<>();
       for(int i=0;i<isConnected.length;i++){
        adjLis.add(new ArrayList<Integer>());
       }
       for(int i=0;i<isConnected.length;i++){
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[i][j] == 1 && i != j){
                adjLis.get(i).add(j);
                adjLis.get(j).add(i);
            }
        }
       }
       int []vis=new int[isConnected.length];
       int count=0;
       for(int i=0;i<isConnected.length;i++){
        if(vis[i] == 0){
            count++;
            dfs(i,adjLis,vis);
        }
       }
        return count;
    }
    void dfs(int node,ArrayList<ArrayList<Integer>>adjLis,int vis[]){

        vis[node]=1;
        for(var it: adjLis.get(node)){
            if(vis[it] == 0){
                dfs(it,adjLis,vis);
            }
        }
    }
    
}