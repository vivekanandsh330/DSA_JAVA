class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=prerequisites.length;
        int indgree[]=new int[numCourses];
        HashMap<Integer,List<Integer>> adj=new HashMap<>();
        for(int i[]:prerequisites){
            adj.computeIfAbsent(i[1],k->new ArrayList<>()).add(i[0]);
            indgree[i[0]]++;
        }
        List<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(indgree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int poll=q.poll();
            ans.add(poll);
            for(int v: adj.getOrDefault(poll,new ArrayList<>())){
                indgree[v]--;
                if(indgree[v] == 0){
                    q.add(v);
                }
            }
        }
        if(ans.size() == numCourses){
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }
        return new int[]{};
        
    }
}