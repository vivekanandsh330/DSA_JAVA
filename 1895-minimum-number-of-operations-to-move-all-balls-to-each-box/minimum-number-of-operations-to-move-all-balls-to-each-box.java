class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            int costs =0;
            for(int j=0;j<n;j++){
                if(boxes.charAt(j) == '1'){
                costs+=Math.abs(i-j);
                }
                ans[i] =costs;
            }
        }
        return ans;
    }
}