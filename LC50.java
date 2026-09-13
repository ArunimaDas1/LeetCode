class Solution {
    public double myPow(double x, int n) {
        long N = n; // Use long to prevent overflow when n = Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double ans = 1.0;
        while (N > 0) {
            if ((N & 1) == 1) { // If N is odd
                ans *= x;
            }
            x *= x; // Square the base
            N >>= 1; // Halve the exponent (N /= 2)
        }

        return ans;
    }
}