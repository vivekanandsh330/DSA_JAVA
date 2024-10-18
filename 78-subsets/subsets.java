class Solution {
    
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subSetList(nums,0,new ArrayList<>());
        return ans;
    }

    void subSetList(int []nums,int idx,List<Integer> sublist){
        if(idx==nums.length){
            ans.add(new ArrayList<>(sublist));
            return;
        }
        sublist.add(nums[idx]);
        subSetList(nums,idx+1,sublist);
        sublist.remove(sublist.size()-1);
        subSetList(nums,idx+1,sublist);
    }
}