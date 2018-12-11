public class LC188 {
    public static int maxProfit(int k, int[] prices) {
        int len = prices.length;
//        if (k >= len / 2) return quickSolve(prices);

        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
                print(t);
                System.out.println();
            }
        }
        return t[k][len - 1];
    }

    public static void print(int[][] nums) {
        for (int[] num : nums) {
            System.out.println();
            for (int i : num) {
                System.out.print(i+" ");
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 5, 0, 3, 1, 5};
        maxProfit(2, nums);
    }

}
