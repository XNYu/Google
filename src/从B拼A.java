import java.util.*;

public class 从B拼A {
    public int findLeastUsedB(String A, String B) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < B.length(); i++) {
            List<Integer> list = map.get(B.charAt(i));
            if(list == null) {
                list = new ArrayList<>();
                map.put(B.charAt(i), list);
            }
            list.add(i);
        }
        System.out.println(map);
        int index = 0;
        int res = 1;
        /*
        存了所有字符出现的位置
        对每个字符，先调出它的“位置列表”
        找到离 index 最近的位置
        然后把当前位置 +1 设成 index, 再去找下一个字符
        【相当于是在这个字符后面的子字符串接着找】
        如果 id == list.size()，意味着找不到比当前index还大的位置了，也就是说在前一个字符后面，没有新的要找的字符了，这时数字加 1
        */
        for(int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            List<Integer> list = map.get(c);
            if(list == null) {
                return -1; // which means there is no way to build the String A
            }
            int id = Collections.binarySearch(list, index);
            if(id < 0) {
                id = -id - 1;
            }
            System.out.println(A.charAt(i));
            System.out.println(index+","+id+","+list);
            if(id == list.size()) {
                System.out.println("!");
                res++;
                index = list.get(0)+1;
            } else {
                index = list.get(id)+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        从B拼A a = new 从B拼A();
        System.out.println(a.findLeastUsedB("abcddd", "admbnc"));
    }
}
