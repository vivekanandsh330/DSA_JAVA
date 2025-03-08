class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n=blocks.length();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=n-k;i++){
            int w=0;
            for(int j=i;j-i+1<=k;j++){
                if(blocks.charAt(j) == 'W'){
                    w++;
                }
            }
            min=Math.min(min,w);
            }
        return min;
    }
}