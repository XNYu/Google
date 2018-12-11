import java.util.HashSet;

public class LC76 {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            if(map[c]==0)
                map[c]--;
        }
        int start = 0, minStart = 0;
        int curLen = 0, min = Integer.MAX_VALUE;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            if(map[c]<0)
                curLen++;
            map[c]++;

            while (curLen == t.length()) {
                if (end - start + 1 < min) {
                    min = end - start + 1;
                    minStart = start;
                }
                char toRemove = s.charAt(start);
                start++;
                if(map[toRemove]==0)
                    curLen--;
                map[toRemove]--;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + min);
    }

    public static void main(String[] args) {
        String a = "ADOBECODEBANC";
        String b = "ABC";
        LC76 l = new LC76();
        System.out.println(l.minWindow(a,b));
    }
}
