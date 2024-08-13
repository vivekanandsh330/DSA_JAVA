class Solution {
    void solve(int i,int target,int []num,List<List<Integer>> ans,List<Integer> ds){
        if(i == num.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(num[i]<=target){
            ds.add(num[i]);
            solve(i,target-num[i],num,ans,ds);
            ds.remove(ds.size()-1);
        }
            solve(i+1,target,num,ans,ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        solve(0,target,candidates,ans,new ArrayList<>());
        return ans;   
    }
}