class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n=times.length;
        int ch[]=new int[n];
        Arrays.fill(ch,-1);
        int savett=times[targetFriend][0];
        Arrays.sort(times,(a,b)-> Integer.compare(a[0],b[0]));
        
        for(int time[]:times){
            int arrival=time[0];
            int depar=time[1];
            for(int j=0;j<n;j++){
                if(ch[j]<=arrival){
                    ch[j]=depar;
                    if(arrival == savett){
                        return j;
                    }
                    break;
                }

            }
        }
        return -1;
    }
}