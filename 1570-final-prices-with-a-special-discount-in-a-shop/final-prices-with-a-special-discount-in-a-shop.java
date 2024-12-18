class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int ans[] = prices.clone();
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && prices[i] <= prices[s.peek()]) {
                int idx = s.pop();
                ans[idx] -= prices[i];
            }
            s.push(i);
        }
        return ans;
    }
}