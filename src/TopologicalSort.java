import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {

    public ArrayList<Integer> sort(int[][] graph) {
        Stack<Integer> s = new Stack<>();
        int[] inD = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == 1) {
                    inD[j]++;
                }
            }
        }
        for (int i = 0; i < inD.length; i++) {
            if(inD[i]==0)
                s.push(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!s.empty()) {
            int p = s.pop();
            ans.add(p);
            for (int i = 0; i < graph[0].length; i++) {
                if(graph[p][i]==1)
                {
                    graph[p][i] = 0;
                    inD[i]--;
                    if(inD[i]==0)
                        s.push(i);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TopologicalSort t = new TopologicalSort();
        int[][] grid = new int[][]{
                {0, 1, 1, 1},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 0},
        };
        System.out.println(t.sort(grid));
    }
}
