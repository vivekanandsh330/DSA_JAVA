class Solution {
    public long findScore(int[] nums) {
        int n=nums.length;
        long fs=0;
        PriorityQueue<int []> pq=new PriorityQueue<>((a,b)->{
            if(a[0] != b[0]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1],b[1]);
        });
        for(int i=0;i<n;i++){
            pq.add(new int[]{nums[i],i});
        }
        boolean vis[]=new boolean[n];
        while(!pq.isEmpty()){
            int []pair=pq.poll();
            int val=pair[0];
            int idx=pair[1];
            if(!vis[idx]){
                fs+=val;
                vis[idx]=true;
                if(idx-1>=0) vis[idx-1]=true;
                if(idx+1<n) vis[idx+1]=true;
            }
        }
        return fs;
    }
}