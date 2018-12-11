public class LC718LongestCommonSubsequence {
    public int findLength(int[] a, int[] b) {
        int m = a.length, n = b.length;
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--)
                // dp[i][j] 是 以A[i] 和 B[j] 结尾的最长公共字符串的长度
                max = Math.max(max, dp[i][j] = a[i] == b[j] ? 1 + dp[i + 1][j + 1] : 0);
        return max;
    }

    public int findLength2(int[] A, int[] B) {
        if(A == null||B == null) return 0;
        int m = A.length;
        int n = B.length;
        int max = 0;
        //dp[i][j] is the length of longest common subarray ending with nums[i] and nums[j]
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0;i <= m;i++){
            for(int j = 0;j <= n;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else{
                    if(A[i - 1] == B[j - 1]){
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                        max = Math.max(max,dp[i][j]);
                    }
                }
            }
        }
        return max;
    }

    // O(N) 空间复杂度
    public int findLength3(int[] A, int[] B) {
        if(A == null || B == null || A.length == 0 || B.length == 0)return 0;
        int Rows = A.length;
        int Cols = B.length;

        // dp[j] is the length of longest common subarray ending with A[i-1], B[j-1]
        int[] dp = new int[Cols + 1];
        int maxLen = 0;
        for (int i = 1; i <=Rows ; i++) {
            for (int j =  Cols; j > 0 ; j--) {
                if(A[i -1] == B[j-1])
                {
                    dp[j] = 1 + dp[j-1] ;
                    maxLen = Math.max(maxLen, dp[j]);
                }else {
                    dp[j] = 0;
                }
            }
        }
        return maxLen;
    }
}
