class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n=classes.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for(int i=0;i<n;i++){
            double currpr=(double)classes[i][0]/classes[i][1];
            double newpr=(double)(classes[i][0]+1)/(classes[i][1]+1);
            double changeinpr=newpr-currpr;
            pq.add(new double[]{changeinpr,i});
        }

        while(extraStudents-->0){
            double curr[]=pq.poll();
            int idx=(int)curr[1];

            classes[idx][0]++;
            classes[idx][1]++;
            double currpr=(double)classes[idx][0]/classes[idx][1];
            double newpr=(double)(classes[idx][0]+1)/(classes[idx][1]+1);
            double changeinpr=newpr-currpr;
            pq.add(new double[]{changeinpr,idx});
        }
        double ans=0;
        for(int i=0;i<n;i++){
            ans += (double)classes[i][0]/classes[i][1];
        }
        return ans/n;

    }
}