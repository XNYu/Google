public class SelectCards {
    int maxScore2(int[] cards) {
        int n = cards.length;
        int[] dp = new int[n + 1];
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += cards[n - i];
            int min = Integer.MAX_VALUE;
            if (i >= 3) min = Math.min(min, dp[n-i+3]);
            if (i >= 2) min = Math.min(min, dp[n-i+2]);
            if (i >= 1) min = Math.min(min, dp[n-i+1]);
            dp[n-i] = sum - min;
        }
        return dp[0];
    }
    int maxScore(int[] cards) {
        int n = cards.length;
        int p, q, r, sum;

        p = q = Integer.MAX_VALUE;

                // init when no card.
                r = sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += cards[n - i];
            int min = Math.min(Math.min(p, q), r);
            p = q;
            q = r;
            r = sum - min;
        }

        return r;
    }

    public int findMaxScore(int[] cards) {
        int[] memo = new int[cards.length];
        int sum = 0;
        for (int card: cards) sum += card;
        return (sum + helper(cards, 0, memo)) / 2;
    }

    public int helper(int[] cards, int cur, int[] memo) {
        // 剩下一张卡， 直接拿掉
        if (cur == cards.length - 1) return cards[cur];
        // 剩下两张卡，可以都拿，可只拿一张
        if (cur == cards.length - 2) return Math.max(cards[cur] - cards[cur + 1], cards[cur] + cards[cur + 1]);
        if (cur == cards.length - 3) {
            // 剩下三张卡，三种情况
            int valOne = cards[cur] - Math.max(cards[cur + 1] - cards[cur + 2], cards[cur + 1] + cards[cur + 2]);
            int valTwo = cards[cur] + cards[cur + 1] - cards[cur + 2];
            int valThree = cards[cur] + cards[cur + 1] + cards[cur + 2];
            return Math.max(valOne, Math.max(valTwo, valThree));
        }
        if (memo[cur] != 0) return memo[cur];
        int oneCardValue = cards[cur] - helper(cards, cur + 1, memo);
        int twoCardValue = cards[cur] + cards[cur + 1] - helper(cards, cur + 2, memo);
        int threeCardValue = cards[cur] + cards[cur + 1] + cards[cur + 2] - helper(cards, cur + 3, memo);
        memo[cur] = Math.max(oneCardValue, Math.max(twoCardValue, threeCardValue));
        return memo[cur];
    }

    public static void main(String[] args) {
        int[] cards = {-1,-2,-3,-4,-5,-6,-7,-4,-3,-2,-1,-2,-1,-2,-3,-4,-5,-6,-7,-4,-3,-2,-1,-2,-1,-2,-3,-4,-5,-6,-7,-4,-3,-2,-1,-2,-1,-2,-3,-4,-5,-6,-7,-4,-3,-2,-1,-2,-3,-4,-5,-6,-7,-4,-3,-2,-1,-2,-3,-4,-5,-6,-7,-4,-3,-2,-1};
        cards = new int[]{1,2,3,4,5,6};
        SelectCards s = new SelectCards();
        Long cur = System.nanoTime();
        System.out.println(s.findMaxScore(cards));
        Long one = System.nanoTime();
        System.out.println(one - cur);
        System.out.println(s.maxScore2(cards));
        Long two = System.nanoTime();
        System.out.println(two - one);
        System.out.println(s.maxScore(cards));
        System.out.println(System.nanoTime() - two);
    }
}
