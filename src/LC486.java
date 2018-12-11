public class LC486 {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n];
        for (int s = n; s >=0 ; s--) {
            for (int e = s + 1; e < n; e++) {
                int a = nums[s] - dp[s + 1][e];
                int b = nums[e] - dp[s][e - 1];
                dp[s][e] = Math.max(a, b);
            }
        }
        return dp[0][n - 1] >= 0;
    }


}
