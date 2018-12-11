import jdk.nashorn.api.tree.Tree;

import java.lang.reflect.Array;
import java.util.*;

public class TwoArrays {
    public static int[] func(int[] A, int[] B,int k) {
        Arrays.sort(A);
        Arrays.sort(B);
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        HashSet<String> set = new HashSet<>();
        int a = A.length - 1, b = B.length - 1;
        int[] ans = new int[k];
        int index = 0;
        queue.add(new int[]{A[a] + B[b], a, b});
        set.add(a + "," + b);
        while (index < k) {
            if(queue.isEmpty())
                break;
            int[] pop = queue.poll();
            ans[index++] = pop[0];
            int ta = pop[1];
            int tb = pop[2];
            int[] one = new int[3], two=new int[3];
            if(ta>0)
                one = new int[]{A[ta - 1] + B[tb], ta - 1, tb};
            if(tb>0)
                two = new int[]{A[ta] + B[tb - 1], ta, tb - 1};
            if (set.add((ta - 1) + "," + tb)) {
                queue.add(one);
            }
            if (set.add(ta + "," + (tb - 1))) {
                queue.add(two);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1,2,2,2};
        int[] B = {1,100,300,300};
        int[] ans = func(A, B, 10);
        for (int i : ans) {
            System.out.print(i+" ");
        }
    }
}
