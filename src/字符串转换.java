import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 字符串转换 {
    public static boolean canConvert(String s, String p) {
        if (s.length() != p.length()) return false;
        if (s.equals(p)) return true;

        Set<Character> set = new HashSet<>();
        for (char c : p.toCharArray()) set.add(c);
        if (set.size() == 26) return false;

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (!map.containsKey(temp) || map.get(temp) == p.charAt(i)) {
                map.put(temp, p.charAt(i));
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConvert("aacc","abcd"));
    }
}
