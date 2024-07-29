class Solution {
    int solve2(int[] rating,int idx,int prev,int count,int dp2[][][]){
        if(count == 0){
            return 1;
        }
        if(idx == rating.length){
            return 0;
        }
         if(dp2[idx][prev+1][count] != -1){
            return dp2[idx][prev+1][count];
        }
        int exclude=solve2(rating,idx+1,prev,count,dp2);
        int include=0;
        if(prev == -1 || rating[idx]>rating[prev]){
            include=solve2(rating,idx+1,idx,count-1,dp2);
        }
        return dp2[idx][prev+1][count]=include+exclude;
    }
    int solve1(int[] rating,int idx,int prev,int count,int dp1[][][]){
        if(count == 0){
            return 1;
        }
        if(idx == rating.length){
            return 0;
        }
        if(dp1[idx][prev+1][count] != -1){
            return dp1[idx][prev+1][count];
        }
        int exclude=solve1(rating,idx+1,prev,count,dp1);
        int include=0;
        if(prev == -1 || rating[idx]<rating[prev]){
            include=solve1(rating,idx+1,idx,count-1,dp1);
        }
        return dp1[idx][prev+1][count]=include+exclude;
    }
    public int numTeams(int[] rating) {
        int dp1[][][]=new int[rating.length][rating.length+1][4];
        int dp2[][][]=new int[rating.length][rating.length+1][4];
        for(int a[][] :dp1){
            for(int a1[]: a){
              Arrays.fill(a1,-1);
            }   
        }
        for(int b[][]: dp2){
            for(int b1[]: b)
            Arrays.fill(b1,-1);
        }
        int in=solve1(rating,0,-1,3,dp1);
        int ex=solve2(rating,0,-1,3,dp2);
        return ex+in;
    }
}