class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1; // 1 way to reach 1st step: (1)
        dp[2] = 2; // 2 ways to reach 2nd step: (1+1) or (2)

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}