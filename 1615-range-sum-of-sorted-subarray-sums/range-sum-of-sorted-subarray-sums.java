class Solution {
    int m=(int)1e9+7;
    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<int[]> mh=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        for(int i=0;i<n;i++){
            mh.add(new int[]{nums[i],i});
        }

        int count=0;
        for(int i=1;i<=right;i++){
            int arr[]=mh.poll();
            if(i>=left){
                count = (count+arr[0])%m;
            }
            if(arr[1] < n-1){
                mh.add(new int[]{arr[0]+nums[arr[1]+1],arr[1]+1});
            }
        }
        return count;
    }
}