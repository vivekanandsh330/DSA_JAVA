class Solution {
    boolean isPossible(int[] time, int totalTrips,long giventime ){
        long actualtime=0;
        for(int i: time){
            actualtime += giventime/i;
        }
        return actualtime>=totalTrips;
    }
    public long minimumTime(int[] time, int totalTrips) {
        int n=time.length;
        long l=1;
        long r=(long)(Arrays.stream(time).min().getAsInt())*totalTrips;
        while(l<r){
            long mid=l+(r-l)/2;
            if(isPossible(time,totalTrips,mid)){
                r=mid;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }
}