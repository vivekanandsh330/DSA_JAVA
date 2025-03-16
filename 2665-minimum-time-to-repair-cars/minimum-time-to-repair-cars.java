class Solution {
    boolean solve(int rank[],int cars,long mid){
        long ccars=0;
        for(int i=0;i<rank.length;i++){
            ccars +=(long)Math.sqrt(mid/rank[i]);
        }
        return ccars>=cars;
    }
    public long repairCars(int[] ranks, int cars) {
        int n=ranks.length;
        long l=1;
        long r=1L * cars * cars * Arrays.stream(ranks).max().orElse(Integer.MIN_VALUE);
        long ans=r;
        while(l<r){
            long mid=l+(r-l)/2;
            if(solve(ranks,cars,mid) == true){
                ans=mid;
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}