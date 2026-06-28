import java.util.*;                      //memoization

class solution{
    public static int solve(int i, int[] height ,int[] dp){
        if(i==0) return 0;
        
        if( dp[i] !=-1 ) return dp[i];

        int onestep= solve(i-1,height,dp) + Math.abs(height[i]-height[i-1]);

        int twostep= Integer.MAX_VALUE;
        if(i>1){
            twostep=solve(i-2,height,dp)+ Math.abs(height[i]-height[i-2]);
        }
         dp[i]=Math.min(onestep,twostep);
         return dp[i];

    }
    public static int jump(int n ,int[] height){
        int[] dp= new int[n];
        Arrays.fill(dp,-1);
        return solve(n-1, height, dp);
        }
   public static void main(String[] args) {
        int[] height = {10, 20, 30, 10};
        int n = height.length;
        System.out.println(jump(n, height)); // 20
    }

}


//tabulation
class solution{
    public static int frogjump(int n, int[]height){
        int[] dp=new int[n];
        dp[0]=0;

        for (int i=1;i<n;i++){
            onestep=dp[i-i]+ Math.abs(height[i]-height[i-1]);

            int twostep=Integer.MAX_VALUE;
            if(i>1){
                twostep=dp[i-2]+Maths.abs(height[i]-height[i-1]);
            }
            dp[i]=Math.min(onestep,twostep);
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        int[] height = {10, 20, 30, 10};
        int n = height.length;
        System.out.println(frogJump(n, height)); // 20
    }
}


//space optimized 

class Solution {
    public static int frogJump(int n, int[] height) {
        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]

        for (int i = 1; i < n; i++) {
            int oneStep = prev1 + Math.abs(height[i] - height[i - 1]);
            int twoStep = Integer.MAX_VALUE;
            if (i > 1) {
                twoStep = prev2 + Math.abs(height[i] - height[i - 2]);
            }

            int curr = Math.min(oneStep, twoStep);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}