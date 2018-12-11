public class LC340bianzhong {
    public static int longestSubstring(String s, int k) {
        int max = 0;
        int left = 0;
        char[] sa = s.toCharArray();
        int[] map = new int[256];
        int maxOcc = 0;
        for (int i = 0; i < sa.length; i++) {
            map[sa[i]]++;
            //在移动左端点的时候不需要变maxOcc了，因为我们需要找的就是 len = k + maxOcc
            if (map[sa[i]] > maxOcc) {
                maxOcc = map[sa[i]];
            }
            while (i - left + 1 > k + maxOcc) {
                map[sa[left]]--;
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public int characterReplacement(String s, int k) {
        // Sliding Window
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            // 计算滑动窗口内的最大相同字符个数
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                // 超出限制，左端右移
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LC340bianzhong l = new LC340bianzhong();
        System.out.println(longestSubstring("aaaaaaabbccdd",3));
    }
}
