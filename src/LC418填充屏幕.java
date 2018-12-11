public class LC418填充屏幕 {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int curRow = 1;
        int len = 0;
        int index = 0;
        int times = 0;
        len += sentence[index++].length();
        while (curRow <= rows) {
            if(index==sentence.length)
            {
                index = 0;
                times++;
            }
            while (len + 1 + sentence[index].length() <= cols) {
                System.out.print(sentence[index]+" ");
                len += 1 + sentence[index++].length();
                if(index==sentence.length)
                {
                    index = 0;
                    times++;
                }
            }
            System.out.println();
            curRow++;
            len = 0;
            if(sentence[index].length()>cols)
                return 0;
            len += sentence[index++].length();
        }
        return times;
    }

    public static void main(String[] args) {
        LC418填充屏幕 l = new LC418填充屏幕();
        String[] strs = {"a","b","c"};
        System.out.println(l.wordsTyping(strs, 8, 7));
    }
}
