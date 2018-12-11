import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class LC318 {
    public static int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        int len = words.length;
        int[] value = new int[len];
        for (int i = 0; i < len; i++) {
            String tmp = words[i];
            value[i] = 0;
            for (int j = 0; j < tmp.length(); j++) {
                // 每一位字母，如果存在
                value[i] |= 1 << (tmp.charAt(j) - 'a');
            }
        }
        int maxProduct = 0;
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++) {
                if ((value[i] & value[j]) == 0 && (words[i].length() * words[j].length() > maxProduct))
                    maxProduct = words[i].length() * words[j].length();
            }
        return maxProduct;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            // 1<<i 代表 1左移i位
            System.out.println(1 << i);
        }
    }
}
