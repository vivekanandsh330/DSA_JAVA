class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(nums1[i],hm.getOrDefault(nums1[i],0)+m);
        }
        for(int i=0;i<m;i++){
            hm.put(nums2[i],hm.getOrDefault(nums2[i],0)+n);
        }
        int ans=0;
        for(int arr:hm.keySet()){
            if(hm.get(arr)%2 !=0){
                ans ^= arr;
            }
        }
        return ans;
    }
}