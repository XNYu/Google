import java.util.*;

public class ShortestDistance {
    HashMap<String, ArrayList<String>> map = new HashMap<>();

    public Map<String, Integer> find(List<String> targets) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        HashMap<String, Integer> distance = new HashMap<>();
        for (String point : targets) {
            queue.add(point);
            distance.put(point, 0);
        }
        while (queue != null) {
            String start = queue.poll();
            int d = distance.get(start) + 1;
            for (String end : map.get(start)) {
                if(!distance.containsKey(end))
                {
                    distance.put(end, d);
                    queue.add(end);
                }
            }
        }
        return distance;
    }
}
