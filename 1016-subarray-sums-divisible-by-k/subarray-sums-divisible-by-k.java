class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        int n=nums.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        int count =0;
        int sum=0;
        int i=0;
        int j=0;
        while(j<n){
            sum +=nums[j];
            int rem = sum % k;
            if( rem < 0){
                rem += k;
            }
            if(hm.containsKey(rem)){
             count += hm.get(rem);
            }
            hm.put(rem,hm.getOrDefault(rem,0)+1);
            j++;
        }
        return count;
    }
}