import java.util.ArrayList;
import java.util.List;

public class TrieTree {
    private class Node {
        int count,duplicate;
        char aChar;
        Node[] children;
        boolean isLeaf;
        public Node(){
            count = 1;
            isLeaf = false;
            children = new Node[26];
        }
    }

    private Node root;

    public TrieTree() {
        root = new Node();
    }

    public void insert(String word) {
        insert(root, word);
    }

    private void insert(Node root, String word) {
        word = word.toLowerCase();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (root.children[index] == null) {
                root.children[index] = new Node();
            }
            else {
                root.children[index].count++;
            }
            if (i == chars.length - 1) {
                root.children[index].isLeaf = true;
                root.children[index].duplicate++;
            }
            root = root.children[index];
            root.aChar = chars[i];
        }
    }

    public void show() {
        show(new StringBuilder(), root);
    }

    public List<String> show(StringBuilder temp, Node root) {
        Node[] children = root.children;
        List<String> ans = new ArrayList<>();
        temp.append(root.aChar);
        if (root.isLeaf) {
            ans.add(temp.toString());
        }
        for (int i = 0; i < children.length; i++) {
            if (children[i] != null) {
                ans.addAll(show(temp, children[i]));
                temp.deleteCharAt(temp.length() - 1);
            }
        }
        return ans;
    }

    public Node search(String start) {
        Node[] children = root.children;
        char[] cs = start.toCharArray();
        Node ans = new Node();
        for (char c : cs) {
            if (children[c-'a'] != null) {
                ans = children[c - 'a'];
                children = ans.children;
            } else {
                return null;
            }
        }
        return ans;
    }

    public List<String> find(String start) {
        Node node = search(start);
        return show(new StringBuilder(start).deleteCharAt(start.length()-1), node);
    }

    public static void main(String[] args) {
        TrieTree t = new TrieTree();
        t.insert("abc");
        t.insert("ab");
        t.insert("blue");
        t.insert("amd");
        t.insert("pokemon");
        t.insert("b");
        t.insert("abpoke");
        t.insert("abss");
        System.out.println(t.find("ab"));
    }
}
