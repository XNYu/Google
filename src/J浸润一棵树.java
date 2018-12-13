import java.util.PriorityQueue;

public class J浸润一棵树 {
    class Node{
        TreeNode node;
        int time;

        public Node(TreeNode node, int time) {
            this.node = node;
            this.time = time;
        }
    }
    public void func(TreeNode root) {
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
        queue.add(new Node(root, root.val));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            TreeNode tree = node.node;
            if (tree.left != null) {
                queue.add(new Node(tree.left, node.time + tree.left.val));
            }
            if (tree.right != null) {
                queue.add(new Node(tree.right, node.time + tree.right.val));
            }
            System.out.print(tree.val+" ");
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(0);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(6);
        TreeNode t6 = new TreeNode(1);
        TreeNode t7 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        J浸润一棵树 j = new J浸润一棵树();
        j.func(t1);
    }
}
