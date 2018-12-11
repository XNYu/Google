import java.util.ArrayList;
import java.util.List;

public class LC442FindDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
        int len = nums.length;
        int i = 0;
        while (i < len) {
            int cur = nums[i];
            while (cur != nums[cur - 1]) {
                swap(i,cur-1,nums);
                cur = nums[i];
            }
            i++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                ans.add(nums[j]);
            }
        }
        return ans;
    }

    public void swap(int i, int j, int[] nums) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
