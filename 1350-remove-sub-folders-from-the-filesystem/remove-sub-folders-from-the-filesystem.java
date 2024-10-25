class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> ans=new ArrayList<>();
        String prev=null;
        for(String currn:folder){
            if(prev == null || !currn.startsWith(prev+"/")){
                ans.add(currn);
                prev=currn;
            }
        }
        return ans;
    }
}