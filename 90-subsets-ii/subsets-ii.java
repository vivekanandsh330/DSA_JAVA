class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    Set<List<Integer>> hm=new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> sublist=new ArrayList<>();
        Arrays.sort(nums);
        findsubset(nums,0,sublist);
        return new ArrayList<>(hm);
    }
    void findsubset(int []nums,int idx,List<Integer> sublist){
        if(idx>=nums.length){
            hm.add(new ArrayList<>(sublist));
            return;
        }
        sublist.add(nums[idx]);
        findsubset(nums,idx+1,sublist);
        sublist.remove(sublist.size()-1);
        findsubset(nums,idx+1,sublist);
    }
}