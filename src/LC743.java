import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class LC743 {
    public int networkDelayTime(int[][] times, int N, int K) {
        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
        HashMap<Integer, Integer> time = new HashMap<>();
        for (int[] edge : times) {
            if(!map.containsKey(edge[0]))
                map.put(edge[0], new ArrayList<>());
            if(!map.containsKey(edge[1]))
                map.put(edge[1], new ArrayList<>());
            map.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(K);
        time.put(K, 0);
        while (!q.isEmpty()) {
            int start = q.poll();
            int t = time.get(start);
            for (int[] edge : map.get(start)) {
                int end = edge[0];
                int duration = edge[1];
                time.put(end, Math.min(time.getOrDefault(end, Integer.MAX_VALUE), t + duration));
                q.add(end);
            }
        }
        int max = 0;
        for (int t : time.values()) {
            max = Math.max(max, t);
        }
        return max;
    }
}
