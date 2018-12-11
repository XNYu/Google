import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

public class PositionOfBigger差的位置 {
    public int[] find(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < nums.length; i++) {
            while (!s.empty()&&nums[s.peek()] < nums[i]) {
                ans[s.pop()] = i;
            }
            s.push(i);
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
        return ans;
    }

    public static void main(String[] args) {
        PositionOfBigger差的位置 c = new PositionOfBigger差的位置();
        c.find(new int[]{7, 5, 3, 1});
    }
}
