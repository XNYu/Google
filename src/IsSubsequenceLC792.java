import java.util.*;

public class IsSubsequenceLC792 {
    public boolean isSubsequence(String s,String t) {
        List<Integer>[] idx = new List[256]; // Just for clarity
        for (int i = 0; i < s.length(); i++) {
            if (idx[s.charAt(i)] == null)
                idx[s.charAt(i)] = new ArrayList<>();
            idx[s.charAt(i)].add(i);
        }
        int prev = 0;
        for (int i = 0; i < t.length(); i++) {
            if (idx[t.charAt(i)] == null)
                return false; // Note: char of S does NOT exist in T causing NPE
            int j = Collections.binarySearch(idx[t.charAt(i)], prev);
            if (j < 0)
                j = -j - 1;
            if (j == idx[t.charAt(i)].size())
                return false;
            prev = idx[t.charAt(i)].get(j) + 1;
        }
        return true;
    }
    public int numMatchingSubseq(String S, String[] words,List<Integer>[] idx) {
       int count = 0;
//       for(String w:words)
//       {
//           if(isSubsequence(w))
//               count++;
//       }
       return count;
    }

    public int numMatchingSubseq3(String S, String[] words) {
        int count = 0;
        for(String w:words)
        {
            if(isSubsequence3(w,S))
                count++;
        }
        return count;
    }

    public boolean isSubsequence3(String s, String t)
    {
        if(t.length() < s.length()) return false;
        int prev = 0;
        for(int i = 0; i < s.length();i++)
        {
            char tempChar = s.charAt(i);
            prev = t.indexOf(tempChar,prev);
            if(prev == -1) return false;
            prev++;
        }
        return true;
    }

    public int numMatchingSubseq2(String S, String[] words) {
        int count = 0;
        for (String w : words) {
            int i = 0;   // word index
            int j = 0;   // S index
            while (j < S.length() && i < w.length()) {
                if (S.charAt(j) == w.charAt(i)) {
                    j ++;
                    i ++;
                } else {
                    j ++;
                }
            }
            if (i == w.length()) count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        IsSubsequenceLC792 l = new IsSubsequenceLC792();
        String S = "abcdef";
        String[] strs = {"a", "ace", "acd", "bb","a", "ace", "acd", "a", "ace", "acd", "bb","a", "ace", "acd", "a", "ace", "acd", "bb","a", "ace", "acd", "a", "ace", "acd", "bb","a", "ace", "acd", "bb","a", "ace", "acd", "bb","a", "ace", "acd", "bb"};
        Long cur = System.nanoTime();

//        for (int i = 0; i < 1000000; i++) {
//            l.numMatchingSubseq(S, strs,idx);
//        };
        Long one = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            l.numMatchingSubseq2(S, strs);
        };
        Long two = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            l.numMatchingSubseq3(S, strs);
        };
        Long three = System.nanoTime();
        System.out.println(one - cur);
        System.out.println(two - one);
        System.out.println(three - two);
    }
}
