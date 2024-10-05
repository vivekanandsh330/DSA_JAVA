class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int mp1[]=new int[26];
       
        for(int i=0;i<n;i++){
            mp1[s1.charAt(i)-'a']++;
        }
        for(int j=0;j<=m-n;j++){
             int mp2[]=new int[26];
        for(int i=0;i<n;i++){
             mp2[s2.charAt(i+j)-'a']++;
        }
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