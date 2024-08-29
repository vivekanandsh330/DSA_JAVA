class Solution {
    private int []parent;
    private int []rank;
    private int n;
    int find(int i){
        if(parent[i] != i){
            parent[i]=find(parent[i]);
        }
        return parent[i];
    }
    void union(int i,int j){
        int ri=find(i);
        int rj=find(j);

        if(ri != rj){
            if(rank[ri] > rank[rj]){
                parent[rj]=ri;
            }
            else if(rank[ri] < rank[rj]){
                parent[ri]=rj;
            }else{
                parent[ri]=rj;
                rank[ri]++;
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n=stones.length;
        parent =new int[n];
        rank=new int[n];
        
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
            rank[i]=1;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    union(i,j);
                }
            }
        }
        int g=0;
        for(int i=0;i<n;i++){
            if(parent[i] == i){
                g++;
            }
        }
        return n-g;   
    }
}