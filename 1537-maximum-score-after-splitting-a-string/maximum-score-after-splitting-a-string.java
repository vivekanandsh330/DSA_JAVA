class Solution {
    public int maxScore(String s) {
        int tone = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                tone++;
            }
        }
        int lzero = 0;
        int one = 0;
        int ans = 0;
        for (int i = 0; i <= s.length() - 2; i++) {
            if (s.charAt(i) == '0') {
                lzero++;
            } else {
                one++;
            }
            int rone = tone - one;
            ans = Math.max(ans, lzero + rone);
        }
        return ans;
    }
}