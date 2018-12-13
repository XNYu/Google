import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UniquePaths {
    // 最基本的题目，从左上角走到右上角，可以→，↗，↘
    public int f1(int m,int n){
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++)
            for (int i = 0; i <= Math.min(Math.min(j,m-1),n-j-1); i++)
            {
                if(i==0&&j==0)
                    dp[i][j] = 1;
                else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j - 1];
                } else if (i < m - 1) {
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j - 1] + dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i-1][j-1];
                }
                print(dp);
            }

        return dp[0][n-1];
    }

    // 优化到O(N)存储
    public int f2(int m, int n) {
        int[] dp = new int[m];
        int[] temp = dp;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= Math.min(Math.min(j, m - 1), n - j - 1); i++) {
                if (i == 0 && j == 0)
                    temp[i] = 1;
                else if (i == 0) {
                    temp[i] = dp[i] + dp[i + 1];
                } else if (i < m - 1) {
                    temp[i] = dp[i] + dp[i + 1] + dp[i - 1];
                } else {
                    temp[i] = dp[i] + dp[i - 1];
                }
            }
            dp = temp;
            temp = new int[m];
            print(dp);
        }
        return dp[0];
    }

    //给三个点，判断是否能过这三个点
    public boolean f3(List<int[]> list) {
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (int[] n : list) {
            System.out.print(n[0]+","+n[1]+" ");
        }
        System.out.println();

        for (int i = 0; i < list.size()-1; i++) {
            int[] p1 = list.get(i);
            int[] p2 = list.get(i + 1);
            int distance = p2[1] - p1[1];
            if(Math.abs(p2[0]-p1[0])>distance)
                return false;
        }
        return true;
    }

    //寻找过这三个点的路径数
    public int f4(List<int[]> list, int m, int n) {
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        list.add(new int[]{m, n});
        int index = 0;
        int[] point = list.get(index);
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= Math.min(Math.min(j, m - 1), n - j - 1); i++) {
                if (i == 0 && j == 0)
                    dp[i][j] = 1;
                else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j - 1];
                } else if (i < m - 1) {
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j - 1] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                }
            }
            if (j == point[1]) {
                for (int i = 0; i < dp.length; i++) {
                    if(i!=point[0])
                        dp[i][j] = 0;
                }
                point = list.get(++index);
            }
            print(dp);
        }
        return dp[0][n - 1];
    }

    public int f5(int m, int n, int H) {
        int[][] yes = new int[m][n];
        int[][] no = new int[m][n];
        for (int j = 0; j < n; j++)
            for (int i = 0; i <= Math.min(Math.min(j,m-1),n-j-1); i++)
            {
                if (i >= H) {
                    if(i==0&&j==0)
                        yes[i][j] = 1;
                    else if (i == 0) {
                        yes[i][j] = yes[i][j - 1] + yes[i + 1][j - 1]+no[i][j - 1] + no[i + 1][j - 1];
                    } else if (i < m - 1) {
                        yes[i][j] = yes[i][j - 1] + yes[i + 1][j - 1] + yes[i - 1][j - 1] + no[i][j - 1] + no[i + 1][j - 1] + no[i - 1][j - 1];
                    } else {
                        yes[i][j] = yes[i][j - 1] + yes[i - 1][j - 1] + no[i][j - 1] + no[i - 1][j - 1];
                    }
                }
                else {
                    if(i==0&&j==0)
                        no[i][j] = 1;
                    else if (i == 0) {
                        no[i][j] = no[i][j - 1] + no[i + 1][j - 1];
                        yes[i][j] = yes[i][j - 1] + yes[i + 1][j - 1];
                    } else if (i < m - 1) {
                        no[i][j] = no[i][j - 1] + no[i + 1][j - 1] + no[i - 1][j - 1];
                        yes[i][j] = yes[i][j - 1] + yes[i + 1][j - 1] + yes[i - 1][j - 1];
                    } else {
                        no[i][j] = no[i][j - 1] + no[i-1][j-1];
                        yes[i][j] = yes[i][j - 1] + yes[i-1][j-1];
                    }

                }
                print(yes);
                print(no);
            }

        return yes[0][n-1];
    }


    void print(int[] nums) {
        for (int n : nums) {
            System.out.print(n+"  ");
        }
        System.out.println();
    }
    void print(int[][] nums) {
        for (int[] n : nums) {
            for (int m : n) {
                System.out.print(m+"  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        UniquePaths u = new UniquePaths();
//        System.out.println(u.f1(5,5));
//        System.out.println(u.f2(5,5));
        List<int[]> list = new ArrayList<>();
//        list.add(new int[]{0, 0});
        list.add(new int[]{5, 9});
        list.add(new int[]{5, 7});
        list.add(new int[]{7, 13});
//        list.add(new int[]{0, 21});
//        System.out.println(u.f3(list));
//        System.out.println(u.f4(list,10,22));
        System.out.println(u.f5(10,10,2));
//        System.out.println(u.f1(10,10));
    }
}
