class Solution {
    public int countSeniors(String[] details) {
        int ans=0;
        for(var ch: details){
            int age=Integer.parseInt(ch.substring(11,13));
            if(age>60){
                ans++;
            }
        }
        return ans;
    }
}