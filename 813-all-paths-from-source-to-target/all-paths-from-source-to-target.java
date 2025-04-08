class Solution {
    int n;
    void dfs(int[][] graph,int u,int target, List<Integer> temp, List<List<Integer>> ans){
        temp.add(u);
        if(u == target){
            ans.add(new ArrayList<>(temp));
        }
        else{
            for(int v:graph[u]){
                dfs(graph,v,target,temp,ans);
            }
        }
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n=graph.length;
        int s=0;
        int d=n-1;
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        dfs(graph,s,d,temp,ans);
        return ans;
    }
}