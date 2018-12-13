public class 数字生成字符串 {

    public static String go(String orin) {
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < orin.length(); i++) {
            char c = orin.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            }
            else if (c == '[') {
                System.out.println(i);
                int count = 1;
                int k = i;
                while (count > 0) {
                    k++;
                    if(orin.charAt(k)==']')
                        count--;
                    else if(orin.charAt(k)=='[')
                        count++;
                }
                String newOrin = orin.substring(i+1, k);
                String toAppend = go(newOrin);
                i = k;
                for (int j = 0; j < num; j++) {
                    sb.append(toAppend);
                }
            } else {
                for (int j = 0; j < Math.max(1,num); j++) {
                    sb.append(c);
                }
                num = 0;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(go("2[a3[bc]]"));
    }
}
