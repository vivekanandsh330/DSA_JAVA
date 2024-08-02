class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int arr[]=new int[2*n];
        for(int i=0;i<2*n;i++){
            arr[i]=nums[i%n];
        }
        int TotalnoOnes=Arrays.stream(nums).sum();
        int i=0;
        int j=0;
        int currOne=0;
        int maxOne=0;
        while(j< 2*n){
            if(arr[j] == 1){
                currOne++;
            }
            if(j-i+1 > TotalnoOnes){
                currOne -= arr[i];
                i++;
            }
            j++;
            maxOne=Math.max(maxOne,currOne);
        }
        return TotalnoOnes-maxOne;
    }
}