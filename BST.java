public class BST {
    public Node tree;
    public BST() {
        tree = null;
    }

    public void add(int x) {
        if (tree == null) {
            tree = new Node(x);
        } else {
            addRecursive(x, tree);
        }
    }

    public void delete(int x) {

    }

    private void addRecursive(int x, Node p) {
        if (x == p.key) {
            return;
        } else if (x < p.key) {
            if (p.left == null) {
                p.left = new Node(x);
            } else {
                addRecursive(x, p.left);
            }
        } else {
            if (p.right == null) {
                p.right = new Node(x);
            } else {
                addRecursive(x, p.right);
            }
        }
    }

    private class Node {
        public int key;
        public Node left;
        public Node right;

        public Node(int x) {
            key = x;
            left = null;
            right = null;
        }

    }

    public static void main(String[] args) {
        BST t = new BST();
        t.add(5);
        t.add(6);
        t.add(9);
        t.add(10);
        t.add(3);
        t.add(5);
    }
}
