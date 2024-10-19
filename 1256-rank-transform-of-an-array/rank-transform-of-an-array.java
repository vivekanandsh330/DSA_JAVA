class Solution {
    public int[] arrayRankTransform(int[] arr) {
       int n=arr.length;
       List<Integer> idx=new ArrayList<>();
       for(int i=0;i<n;i++){
        idx.add(i);
       }
       Collections.sort(idx,(a,b)-> arr[a]-arr[b]);
       int ans[]=new int[n];
       int rank=0;
       int prev=Integer.MIN_VALUE;
       for(int i:idx){
        if(arr[i]>prev){
            prev=arr[i];
            rank++;
        }
        ans[i]=rank;
       }
       return ans;
    }
}