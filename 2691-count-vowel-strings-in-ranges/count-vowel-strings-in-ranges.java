class Solution {
    boolean isVowel(char ch){
        if(ch =='a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n=queries.length;
        int w=words.length;

        int sum[]=new int[w];
        int count=0;
        for(int i=0;i<w;i++){
            if(isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length()-1))){
                count++;
            }
            sum[i]=count;
        }
        int ans[]=new int[n];
        for(int i= 0;i<n;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            ans[i]=sum[r]- (l>0 ?sum[l-1]:0);

        }
        return ans;

    }
}