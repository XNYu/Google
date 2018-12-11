import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class LC269AlienDict {
    public String alienOrder(String[] words) {
        int max = 0;
        HashMap<Character, HashSet<Character>> map = new HashMap<>();
        HashMap<Character, Integer> ind = new HashMap<>();
        HashSet<Character> letterSet = new HashSet<>();
        for (String word : words) {
            max = Math.max(word.length(), max);
            for (char c : word.toCharArray()) {
                ind.put(c, 0);
            }
        }
        for (int i = 0; i < words.length-1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int index = 0;
            while (index < Math.min(w1.length(), w2.length())) {
                char c1 = w1.charAt(index), c2 = w2.charAt(index);

                if (c1 != c2) {
                    HashSet<Character> set = map.getOrDefault(c1, new HashSet<>());
                    set.add(c2);
                    map.put(c1, set);
                    ind.put(c2, ind.getOrDefault(c2, 0) + 1);
                    break;
                } else {
                    index++;
                }
            }
        }
        System.out.println(ind);
        Stack<Character> stack = new Stack<>();
        for (Map.Entry e : ind.entrySet()) {
            if((int)e.getValue()==0)
                stack.push((char) e.getKey());
        }
        StringBuilder ans = new StringBuilder();
        System.out.println(stack);
        while (!stack.empty()&&!map.isEmpty()) {
            char c = stack.pop();
            ans.append(c);
            System.out.println(c);
            if(map.containsKey(c))
            for (char end : map.get(c)) {
                int indegree = ind.get(end);
                indegree--;
                if(indegree==0)
                    stack.push(end);
                ind.put(end, indegree);
            }
            map.remove(c);
        }
        if (ans.length() != ind.size()) {
            return "";
        }
        return ans.toString();
    }


}
