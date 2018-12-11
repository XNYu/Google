import java.util.HashMap;

public class LC246 {
    public boolean isStrobogrammatic(String num) {
        StringBuilder reversed = new StringBuilder();
        char[] cs = num.toCharArray();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('1', '1');
        map.put('8', '8');
        map.put('0', '0');
        for (int i = cs.length-1; i >= 0 ; i--) {
            if(!map.containsKey(cs[i]))
                return false;
            char rev = map.get(cs[i]);
            if (rev != cs[cs.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
