import java.util.LinkedList;
import java.util.List;

public class Permutations {
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new LinkedList<>(), new LinkedList<>());
        return ans;
    }

    public void backtrack(int[] nums, LinkedList<Integer> cur, LinkedList<Integer> visited) {
        if (cur.size() == nums.length) {
            ans.add(new LinkedList<>(cur));
        }
        for (int num : nums) {
            if(visited.contains(num))
                continue;
            visited.add(num);
            cur.add(num);
            backtrack(nums, cur, visited);
            cur.removeLast();
            visited.removeLast();
        }
    }
}
