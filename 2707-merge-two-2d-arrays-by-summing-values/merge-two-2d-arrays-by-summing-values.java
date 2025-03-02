class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        HashMap<Integer,Integer> hm=new HashMap<>();

        for(int []num:nums1){
            hm.put(num[0],num[1]);
        }
        for(int []num:nums2){
            hm.put(num[0],hm.getOrDefault(num[0],0)+num[1]);
        }
        int ans[][]=new int[hm.size()][2];
        int j=0;
        for(int i:hm.keySet()){
            ans[j][0]=i;
            ans[j][1]=hm.get(i);
            j++;
        }
        Arrays.sort(ans,(a,b)->a[0]-b[0]);
        return ans;
    }
}