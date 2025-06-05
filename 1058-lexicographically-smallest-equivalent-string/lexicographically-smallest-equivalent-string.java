class Solution {
    char dfs(char currch,Map<Character,List<Character>> adj,int vis[]){
        vis[currch-'a']=1;
        char minch=currch;
        for(char v:adj.getOrDefault(currch,new ArrayList<>())){
            if(vis[v-'a'] != 1){
                vis[v-'a']=1;
                minch=(char)Math.min(minch,dfs(v,adj,vis));
            }
        }
        return minch;
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n1=s1.length();
        int b=baseStr.length();

        Map<Character,List<Character>> adj=new HashMap<>();
        for(int i=0;i<n1;i++){
            char u=s1.charAt(i);
            char v=s2.charAt(i);
            adj.computeIfAbsent(u,k->new ArrayList<>()).add(v);
            adj.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }
        String ans="";
        for(int i=0;i<b;i++){
            char ch=baseStr.charAt(i);
            int vis[]=new int[26];
            char minch=dfs(ch,adj,vis);
            ans += minch;
        }
        return ans;
    }
}