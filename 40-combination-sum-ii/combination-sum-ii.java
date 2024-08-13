class Solution {
    void solve(int i,int target,int []num,List<List<Integer>> ans,List<Integer> ds){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
                return;
            }
            for(int j=i;j<num.length;j++){
            if(j>i && num[j] == num[j-1])continue;
            if(num[j]>target)break;
            ds.add(num[j]);
            solve(j+1,target-num[j],num,ans,ds);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        solve(0,target,candidates,ans,new ArrayList<>());
        return ans;   
    }
}