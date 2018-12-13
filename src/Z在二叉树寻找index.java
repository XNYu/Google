import java.util.Stack;

public class Z在二叉树寻找index {

    public boolean find2(TreeNode root, int index) {
        if (root == null) {
            return false;
        }
        int len = (int)Math.floor(Math.log(index) / Math.log(2));
        int num = (int)Math.pow(2, len-1);
        while (root != null && num>=1) {
            if ((index & num) != 0) {
                root = root.right;
            } else {
                root = root.left;
            }
            System.out.println(root==null?0:root.val);
            num /= 2;
        }
        return root != null;
    }
    // 可以用Bit Manipulation
    public boolean find(TreeNode root,int index) {
        if(root==null)
            return false;
        Stack<Integer> stack = new Stack<>();
        while (index != 1) {
            stack.push(index);
            index /= 2;
        }
        stack.push(1);
        System.out.println(stack);
        int cur, nxt;
        nxt = stack.pop();
        while (!stack.empty() && root != null) {
            cur = nxt;
            nxt = stack.pop();
            if (cur * 2 == nxt) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root != null;
    }
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t7 = new TreeNode(7);
        t2.left = t4;
        t2.right = t5;
        t3.right = t7;
        t1.left = t2;
        t1.right = t3;
        t7.right = new TreeNode(15);
        Z在二叉树寻找index z = new Z在二叉树寻找index();
        System.out.println(z.find2(t1, 15));

    }
}
