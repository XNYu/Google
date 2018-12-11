import java.util.Collections;
import java.util.List;

public class LC524LongestSubsequence {
    //更快的方法
    public String findLongestWord2(String s, List<String> d) {
        int max = 0;
        String ans = "";
        for (String word : d) {
            if (isSubsequence(word, s)
                    && (word.length() > max || word.length() == max && word.compareTo(ans) < 0)) {
                ans = word;
                max = word.length();
            }
        }
        return ans;
    }

    // check whether t is subsequence of s
    boolean isSubsequence(String t, String s) {
        int i = 0, index = -1;
        while (i < t.length()) {
            char cur = t.charAt(i);
            index = s.indexOf(cur, index + 1);
            if (index == -1) {
                return false;
            }
            i++;
        }
        return true;
    }


    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (o1, o2) -> {if (o1.length()==o2.length())
        return o1.compareTo(o2);
                    return o2.length() - o1.length();}
         );
        for (String dd : d) {
            if(dd.length()>s.length())
                continue;
            if (isSub(s, dd)) {
                return dd;
            }
        }
        return "";
    }

    public boolean isSub(String s, String d) {
        int is = 0, id = 0;
        while (is < s.length() && id < d.length()) {
            if (d.charAt(id) == s.charAt(is)) {
                id++;
                is++;
            } else {
                is++;
            }
        }
        if (id == d.length()) {
            return true;
        }
        String a = "";
        a.equals("");
        return false;
    }

}
