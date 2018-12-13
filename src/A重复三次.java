import java.util.ArrayList;
import java.util.List;

public class A重复三次 {
    public List<String> func(String str) {
        List<List<String>> parts = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            int count = 0;
            while (i < cs.length-1 && cs[i] == cs[i + 1]) {
                count++;
                i++;
            }
            List<String> part = new ArrayList<>();
            if (count == 0) {
                part.add(""+cs[i]);
            } else if (count == 1) {
                part.add("" + cs[i - 1] + cs[i - 1]);
            } else {
                part.add(""+cs[i - 1]);
                part.add("" + cs[i - 1] + cs[i - 1]);
            }
            parts.add(part);
        }
        for (List<String> part : parts) {
            if (ans.size() == 0) {
                ans.addAll(part);
            } else {
                List<String> tmp = new ArrayList<>();
                for (String prefix : ans) {
                    for (String ends : part) {
                        tmp.add(prefix + ends);
                    }
                }
                ans = tmp;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        A重复三次 a = new A重复三次();
        System.out.println(a.func("heeellloooaa"));
    }
}
