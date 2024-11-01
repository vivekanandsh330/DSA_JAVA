class Solution {
    long dp[][];
    long solve(int i,int j,List<Integer> robot,List<Integer> pos){
        int n=robot.size();
        if(i>=n){
            return 0;
        }
        if(j>=pos.size()){
            return (long)1e12;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        long inc=Math.abs(robot.get(i)-pos.get(j))+solve(i+1,j+1,robot,pos);
        long ex=solve(i,j+1,robot,pos);
        return dp[i][j]=Math.min(inc,ex);
    }
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory,(a,b)->(a[0]-b[0]));
        List<Integer> pos=new ArrayList<>();
        int n=robot.size();
        for(int i=0;i<factory.length;i++){
            int l=factory[i][1];
            int p=factory[i][0];
            for(int j=0;j<l;j++){
                pos.add(p);
            }
        }
        int m=pos.size();
        dp=new long[n+1][m+1];
        for(long e[]:dp){
            Arrays.fill(e,-1);
        }
        return solve(0,0,robot,pos);
    }
}