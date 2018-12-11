public class LC69Sqrt {
    public int mySqrt(int x) {
        long start = 0;
        long end = x;
        long number, n;
        while (end > start) {
            number = (end - start) / 2 + start;
            n = number * number;
            if(n==x)
                break;
            if (n >= x) {
                end = number-1;
            }
            else
                start = number+1;
            System.out.println(start+" "+end +" "+ n);
        }
        number = (end - start) / 2 + start;
        if(number*number>x)
            return (int) number - 1;
        return (int)number;
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(Integer.MAX_VALUE));
        LC69Sqrt l = new LC69Sqrt();
        System.out.println(l.mySqrt(4));
    }
}
