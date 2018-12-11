import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LC662 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    HashMap<Integer, Integer> leftMost = new HashMap<>();
    int max = 1;
    public int widthOfBinaryTree(TreeNode root) {
        traverse(root, 0, 1);
        return max;
    }
    public void traverse(TreeNode root, int depth, int pos) {
        if (root == null) {
            return;
        }
        depth++;
        if (!leftMost.containsKey(depth)) {
            leftMost.put(depth, pos);
        }
        max = Math.max(pos - leftMost.get(depth)+1, max);
        traverse(root.left, depth, pos * 2);
        traverse(root.right, depth, pos * 2 + 1);
    }
}
