class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int TotalnoOnes=Arrays.stream(nums).sum();
        int i=0;
        int j=0;
        int currOne=0;
        int maxOne=0;
        while(j< 2*n){
            if(nums[j%n] == 1){
                currOne++;
            }
            if(j-i+1 > TotalnoOnes){
                currOne -= nums[i%n];
                i++;
            }
            j++;
            maxOne=Math.max(maxOne,currOne);
        }
        return TotalnoOnes-maxOne;
    }
}