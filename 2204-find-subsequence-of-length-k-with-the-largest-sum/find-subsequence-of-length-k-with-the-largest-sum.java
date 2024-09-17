class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> a[0]-b[0]);
        for(int num=0;num<nums.length; num++){
            pq.add(new int[]{nums[num],num});
            if(pq.size()>k){
                pq.poll();
            }
        }
        Set<Integer> st=new HashSet<>();
        while(!pq.isEmpty()){
            int []idx=pq.poll();
            st.add(idx[1]);
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