import java.util.Arrays;
import java.util.PriorityQueue;

public class X削减工资 {

    public int func2(int[] nums, int budget) {
        PriorityQueue<Integer> stack = new PriorityQueue<>();
        int cur = budget / nums.length;
        int remaining = nums.length;
        for (int i : nums) {
            if (i > cur) {
                stack.add(i);
            } else {
                remaining -= 1;
                cur += (cur - i) / remaining;
                while (stack.peek() <= cur) {
                    remaining -= 1;
                    cur += (cur - stack.poll()) / remaining;
                }
            }
        }
        return cur;
    }

    public int func(int[] nums, int budget) {
        int k = 0;
        int cur = 0;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (cur + nums[i] * (len - i) >= budget) {
                return (budget - cur) / (len - i);
            }
            cur += nums[i];
        }
        return nums[len - 1];
    }

    public static void main(String[] args) {
        int[] nums = {400, 500, 600, 250, 0};
        X削减工资 x = new X削减工资();
        System.out.println(x.func2(nums,1500));
    }
}
