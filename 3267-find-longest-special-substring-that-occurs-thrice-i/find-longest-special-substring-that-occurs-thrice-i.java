class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringBuilder t = new StringBuilder();
            for (int j = i; j < n; j++) {
                if (t.length() != 0 && t.charAt(0) != s.charAt(j)) {
                    break;
                }
                t.append(s.charAt(j));
                map.put(t.toString(), map.getOrDefault(t.toString(), 0) + 1);
            }
        }
        int ans = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 3) {
                ans = Math.max(ans, entry.getKey().length());
            }
        }
        return ans == 0 ? -1 : ans;
    }
}
