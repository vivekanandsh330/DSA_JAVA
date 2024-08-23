class Solution {
    public String fractionAddition(String expression) {
        int numerator = 0;
        int denominator = 1;
        String[] fractions = expression.split("(?=[+-])");
        for (String frac : fractions) {
            String[] parts = frac.split("/");
            int num = Integer.parseInt(parts[0]);
            int denom = Integer.parseInt(parts[1]);
            numerator = numerator * denom + num * denominator;
            denominator *= denom;
            int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
            numerator /= gcd;
            denominator /= gcd;
        }
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        return numerator + "/" + denominator;
    }
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
