class Solution {
    public int[] sortArray(int[] nums) {
        int mine=Arrays.stream(nums).min().getAsInt();
        int maxe=Arrays.stream(nums).max().getAsInt();
        Map<Integer,Integer> hm=new HashMap<>();
        for(int num:nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        int j=0;
        for(int i=mine;i<=maxe;i++){
            while(hm.getOrDefault(i,0)>0){
                nums[j++]=i;
                hm.put(i,hm.get(i)-1);
            }
        }
        return nums;
    }
}