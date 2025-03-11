class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int mp[]=new int[3];
        int i=0;
        int j=0;
        int ans=0;
        while(j<n){
            char ch= s.charAt(j);
            mp[ch-'a']++;
            while(mp[0]>0 && mp[1]>0 && mp[2]>0){
                ans += (n-j);
                mp[s.charAt(i)-'a']--;
                i++;
            }
            j++;
        }
        return ans;
    }
}