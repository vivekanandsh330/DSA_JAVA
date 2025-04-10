class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=prerequisites.length;
        Map<Integer,List<Integer>> adj=new HashMap<>();
        int indgree[]=new int[numCourses];
        for(int i[]:prerequisites){
            adj.computeIfAbsent(i[1],k-> new ArrayList<>()).add(i[0]);
            indgree[i[0]]++;
        }

        Queue<Integer> q=new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(indgree[i] == 0){
                q.add(i);
            }
        }
        int count=0;
        int ans[]=new int[numCourses];
        int k=0;
        while(!q.isEmpty()){
            int poll=q.poll();
            count++;
            ans[k]=poll;
            k++;
            for(int v:adj.getOrDefault(poll,new ArrayList<>())){
                indgree[v]--;
                if(indgree[v] == 0){
                    q.add(v);
                }
            }
        }
        if(count == numCourses){
            return ans;
        }
        return new int[]{};
        
    }
}