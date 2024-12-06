class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int p=0;
        int count=0;
        int sum=0;
        Arrays.sort(banned);
        for(int i=1;i<=n;i++){
            if(p<banned.length && i == banned[p]){
                while(p<banned.length && i == banned[p]){
                    p++;
                }
            }
            else{
            sum+=i;
            if(sum<=maxSum){
                count++;
            }
            else{
                break;
            }
            }
        }
        return count;
    }
}