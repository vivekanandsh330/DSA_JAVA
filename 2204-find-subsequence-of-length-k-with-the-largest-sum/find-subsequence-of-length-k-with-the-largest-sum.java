class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<nums.length;i++){
            pq.add(new int[]{nums[i],i});
            if(pq.size() > k){
                pq.poll();
            }
        }
        Set<Integer> st=new HashSet<>();
        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            st.add(curr[1]);
        }

        int ans[]=new int[k];
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(st.contains(i)){
            ans[j++]=nums[i];
            }
        }
        return ans;
    }
}