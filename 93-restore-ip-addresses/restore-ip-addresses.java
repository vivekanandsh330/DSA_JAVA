class Solution {
    int n;
    List<String> ans=new ArrayList<>();
    boolean isvalid(String s){
        if(s.charAt(0) == '0'){
            return false;
        }
        int val=Integer.parseInt(s);
        return val <=255;
    }
    void solve(String s,int idx,int part,String curr){
        if(idx == n && part == 4){
            ans.add(curr.substring(0,curr.length()-1));
        }
        if(idx+1<=n){
            solve(s,idx+1,part+1,curr+s.substring(idx,idx+1)+".");
        }
        if(idx+2<=n && isvalid(s.substring(idx,idx+2))){
            solve(s,idx+2,part+1,curr+s.substring(idx,idx+2)+".");
        }
        if(idx+3<=n && isvalid(s.substring(idx,idx+3))){
             solve(s,idx+3,part+1,curr+s.substring(idx,idx+3)+".");
        }

    }
    public List<String> restoreIpAddresses(String s) {
        n=s.length();
        ans.clear();
        String curr="";
        if(n>12){
            return ans;
        }
        int idx=0;
        int part=0;
        solve(s,0,part,curr);
        return ans;
    }
}