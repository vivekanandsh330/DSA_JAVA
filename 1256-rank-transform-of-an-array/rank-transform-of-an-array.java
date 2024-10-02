class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n= arr.length;
        List<Integer> idx=new ArrayList<>();
        for(int i=0;i<n;i++){
            idx.add(i);
        }
        Collections.sort(idx,(a,b)-> arr[a]-arr[b]);
        int rank=0;
        int prev=Integer.MIN_VALUE;
        int ans[]=new int[n];
        for(int i: idx){
            if(prev != arr[i] ){
                prev=arr[i];
                rank++;
            }
            ans[i]=rank;
        }
        return ans;
    }
} 