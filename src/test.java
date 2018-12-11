
public class test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String ss = "1234567890";
        String ans = ss.substring(0, 3) + ss.substring(4, 6) + ss.substring(7, 9);
        System.out.println(ans);
    }
}
