class Solution {
    public boolean isThree(int n) {
        int c = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                c++;
                System.out.println(c);
            }
        }
        if (c == 3) {
            return true;
        }
        return false;
    }
}