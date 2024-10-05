class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int mp1[]=new int[26];
        int mp2[]=new int[26];
        if(m<n){
            return false;
        }
        for(int i=0;i<n;i++){
            mp1[s1.charAt(i)-'a']++;
            mp2[s2.charAt(i)-'a']++;
        }
        if(isMatch(mp1,mp2) == true){
            return true;
        }
        for(int j=1;j<=m-n;j++){
            mp2[s2.charAt(j-1)-'a']--;
            mp2[s2.charAt(j+n-1)-'a']++;
        if(isMatch(mp1,mp2) == true){
            return true;
        }
        }
        return false;
    }
    boolean isMatch(int mp[],int mp2[]){
        for(int i=0;i<26;i++){
            if(mp[i] != mp2[i]){
                return false;
            }
        }
        return true;
    }
}