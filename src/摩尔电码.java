import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class 摩尔电码 {
    public static HashMap<String, String> map = new HashMap<>();
    public static void main(String[] args) throws IOException {

        //solution(a, b, 3);
        String[] words = new String[]{"qsd", "d","ad","dasd"};
        String[] d = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        String[] dd = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "y", "x", "z"};

        List<String> word = new ArrayList<>();
        for(int i=0;i<26;i++){
            map.put(d[i],dd[i]);
            word.add(d[i]);
        }
        String s = ".--.-.";
        System.out.println(wordBreak(s, word)); // solution("qsdasdad",words);
    }
    public static HashMap<String, List<String>>map2 = new HashMap<>();
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        if(s == null || wordDict.size() == 0 )return res;
        if(map2.containsKey(s)){
            return map2.get(s);
        }
        if(wordDict.contains(s)|| map.containsKey(s)){
            System.out.println(s + " " + map.get(s));
            res.add(map.get(s));
        }
        for(int i = 1;i<s.length();i++) {
            String tmp = s.substring(i);
            if (wordDict.contains(tmp)) {
                List<String> l = wordBreak(s.substring(0, i), wordDict); // cat  // cat sand
                if (l.size() > 0) {
                    for (int j = 0; j < l.size(); j++) {
                        res.add(l.get(j) + "" + map.get(tmp));
                    }
                }
            }
        }
        map2.put(s,res);
//        System.out.println(res);
        return res;
    }

}
