class Solution {
    public int minimumOperations(int[] nums) {
        int ans=0;
        Queue<Integer> q=new ArrayDeque<>();
        for(int num:nums){
            q.add(num);
        }

        while(!q.isEmpty()){
            Set<Integer> dis=new HashSet<>(q);
            if(dis.size() == q.size()){
                break;
            }
            int count=0;
            while(!q.isEmpty() && count<3){
                q.poll();
                count++;
            }
            ans++;
        }
        return ans;
    }
}