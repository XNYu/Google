public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int count = 0;
        int cur = 0;
        int max = 0;
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if(c==')')
            {
                if (cur > 0) {
                    cur--;
                    count++;
                }
                else
                    count = 0;
            } else if (c == '(') {
                cur++;
                count++;
            }
            if(cur==0)
                max = Math.max(count, max);
        }
        count = 0;
        cur = 0;
        for (int i = s.length()-1; i >=0 ; i--) {
            char c = cs[i];
            if(c=='(')
            {
                if (cur > 0) {
                    cur--;
                    count++;
                }
                else
                    count = 0;
            } else if (c == ')') {
                cur++;
                count++;
            }
            if(cur==0)
                max = Math.max(count, max);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestValidParentheses l = new LongestValidParentheses();
        System.out.println(l.longestValidParentheses("()))))()"));
    }
}
