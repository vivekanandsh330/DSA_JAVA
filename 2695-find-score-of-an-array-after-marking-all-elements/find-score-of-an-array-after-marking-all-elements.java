class Solution {
    public long findScore(int[] nums) {
        int n=nums.length;
        long fs=0;
        boolean vis[]=new boolean[n];
        List<int []> pair=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            pair.add(new int []{nums[i],i});
        }
        pair.sort((a,b)-> a[0] != b[0] ? a[0]-b[0]:a[1]-b[1]);
      //  pair.sort((a,b)-> a[0] != b[0] ? Integer.compare(a[0],b[0]) : Integer.compare(a[1],a[1]));
        for(int p[]:pair){
            int val=p[0];
            int idx=p[1];
            if(!vis[idx]){
                fs += val;
                vis[idx]=true;
                if(idx-1>=0) {
                    vis[idx-1]=true;
                }
                if(idx+1<n){
                 vis[idx+1]=true;
                }
                    
            }

        }
        return fs;
    }
}