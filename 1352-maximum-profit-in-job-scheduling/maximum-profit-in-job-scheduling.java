class Solution {
    class job{
        int startTime;
        int endTime;
        int profit;
        job(int st,int et,int p){
            this.startTime=st;
            this.endTime=et;
            this.profit=p;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<job> jobs=new ArrayList<>();
        for(int i=0;i<startTime.length;i++){
            jobs.add(new job(startTime[i],endTime[i],profit[i]));
        }
        int ans=Integer.MIN_VALUE;
        Collections.sort(jobs, (a,b)->a.endTime-b.endTime);
        TreeMap<Integer,Integer> tm=new TreeMap<>();
        for(job currjob:jobs){
            Integer entryTillstartTime=tm.floorKey(currjob.startTime);
            int maxProfitTillstartTime=(entryTillstartTime == null ? 0:tm.get(entryTillstartTime));
            ans=Math.max(ans,maxProfitTillstartTime+currjob.profit);
            tm.put(currjob.endTime,ans);
        }
        return ans;
    }
}