class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        int k=0;
        for(int i=1;i<n;i++){
            if(intervals[k][1]>=intervals[i][0]){
                intervals[k][1]=Math.max(intervals[i][1],intervals[k][1]);
            }
            else{
                k++;
                intervals[k]=intervals[i];
            }
        }
        return Arrays.copyOfRange(intervals,0,k+1);
    }
}