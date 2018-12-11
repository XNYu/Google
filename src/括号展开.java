import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 括号展开 {
    public List<String> func(String pattern) {
        if (pattern.indexOf('{') == -1) {
            String[] strs = pattern.split(",");
            return Arrays.asList(strs);
        }
        char[] cs = pattern.toCharArray();
        List<String> ans = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        String tmp = "";
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c == '{') {
                ans.add(tmp);
                List<String> temp = new ArrayList<>();
                int j = i;
                int count = 1;
                while (count > 0) {
                    j++;
                    if (cs[j] == '{')
                        count++;
                    else if (cs[j] == '}')
                        count--;
                }
                List<String> ret = func(pattern.substring(i + 1, j));
                List<String> another = func(pattern.substring(j+1, pattern.length()));
                for (String a : ans) {
                    for (String b : ret) {
                        temp.add(a + b);
                    }
                }
                ans = new ArrayList<>(temp);
                temp = new ArrayList<>();
                for (String b:another){
                    for (String a : ans) {
                        temp.add(a + b);
                    }
                }
                answer.addAll(temp);
                System.out.println("answer"+answer);
                return answer;
            } else if (c == ',') {
                answer.add(tmp);
                tmp = "";
            } else {
                tmp += c;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        括号展开 k = new 括号展开();
        System.out.println(k.func("a{b,c{d,e{f,g{h,i{j,k}{l,m}}}}}"));
    }
}
