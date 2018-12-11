import java.util.Arrays;

public class TwentyOnePoints {
    public double bustProb(int total) {
        if(total > 21) return 1.0;
        if(total >= 17){
            return 0;
        }

        double prob = 0.0;
        for(int i = 1; i <=10; i++){
            prob += 0.1 * bustProb(total+i);
        }
        return prob;
    }

    public double func() {
        int[] dp = new int[101];
        Arrays.fill(dp,0);
        for (int i = 1; i <= 10; i++) {
            dp[i]++;
        }
        int win = 0;
        long total = 0;
        for (int i = 2; i <= 10; i++) {
            int[] tmp = new int[101];
            for (int k = 1; k < dp.length; k++) {
                if (k > 21) {
                    total += dp[k];
                    dp[k] = 0;
                    continue;
                }
                else if(k>=17&&k<=21)
                {
                    win += dp[k];
                    total += dp[k];
                    dp[k] = 0;
                    continue;
                }
                for (int j = 1; j <= 10; j++)
                    if(dp[k]!=0)
                        tmp[k + j] += dp[k];
            }
            dp = tmp;
        }
        for (int i = 1; i < dp.length ; i++) {
            System.out.print(dp[i]+"   ");
            if(i%10==0)
                System.out.println();
            if (i >= 17 && i <= 21) {
                win += dp[i];
            }
            total += dp[i];
        }
        System.out.println(win);
        System.out.println(total);
        return (double) (total-win) / total;
    }

    public static void main(String[] args) {
        TwentyOnePoints t = new TwentyOnePoints();
        System.out.println(t.bustProb(0));
    }

}
