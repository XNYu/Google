import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCycles {
    String ans = "";
    int min = Integer.MAX_VALUE;
    public void find(Map<Integer, List<Integer>> graph) {
        List<Integer> list = new ArrayList<>();
        for (int i : graph.keySet()) {
            find(i, new ArrayList<>(), graph);
        }
    }

    public void find(int point, List<Integer> trace,Map<Integer, List<Integer>> graph) {
        if (trace.indexOf(point) != -1) {
            int j = trace.indexOf(point);
            StringBuilder newsb = new StringBuilder();
            while (j < trace.size()) {
                newsb.append(trace.get(j++));
            }
            newsb.append(point);
            if (newsb.length() < min) {
                min = newsb.length();
                ans = newsb.toString();
                System.out.println(ans);
            }
            return;
        }
        trace.add(point);
        for (int dist : graph.get(point)) {
            find(dist, trace, graph);
        }
        trace.remove(trace.size() - 1);
    }

    public static void main(String[] args) {
        List<Integer> l0 = new ArrayList<>();
        l0.add(1);
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(0);
        l2.add(3);
        List<Integer> l3 = new ArrayList<>();
        l3.add(0);
        l3.add(1);
        FindCycles f = new FindCycles();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, l0);
        graph.put(1, l1);
        graph.put(2, l2);
        graph.put(3, l3);
        f.find(graph);
    }
}
