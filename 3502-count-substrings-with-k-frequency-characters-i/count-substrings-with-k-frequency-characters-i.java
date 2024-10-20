class Solution {
    public int numberOfSubstrings(String s, int k) {
        int n=s.length();
        int fre[]=new int[26];
        int ans=0;
        for(int i=0;i<n;i++){
            Arrays.fill(fre,0);
            int mx=0;
            for(int j=i;j<n;j++){
                fre[s.charAt(j)-'a']++;
                mx=Math.max(mx,fre[s.charAt(j)-'a']);
                if(mx>=k){
                    ans+=n-j;
                    break;
                }
            }
        }
        return ans;
    }
}