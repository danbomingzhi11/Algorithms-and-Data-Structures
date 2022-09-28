import java.util.LinkedList;
import java.util.Queue;

public class BST<E extends Comparable<E>> {
    private class Node {
        E e;
        Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private int size;
    public Node root;

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    public void add(Node node, E e) {
        if (node.e.equals(e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        if (node.e.compareTo(e) > 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }
    }

    public void betterAdd(E e) {
        root = betterAdd(root, e);
    }

    // 更简单的add递归
    public Node betterAdd(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (node.e.compareTo(e) < 0) {
            betterAdd(node.left, e);
        } else {
            betterAdd(node.right, e);
        }
        return node;
    }

    // 查询元素是否存在
    public boolean contains(E e) {
        return contains(root, e);
    }

    public boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (node.e.compareTo(e) == 0) {
            return true;
        }

        if (node.e.compareTo(e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    // 前序遍历
    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println("前序遍历");
        preOrder(node.left);
        preOrder(node.right);
    }


    // 中序遍历
    public void midOrder() {
        preOrder(root);
    }

    public void midOrder(Node node) {
        if (node == null) {
            return;
        }

        midOrder(node.left);
        System.out.println("中序遍历");
        midOrder(node.right);
    }

    // 后序遍历
    public void postOrder(Node node) {
        if (node == null) {
            return;
        }

        midOrder(node.left);
        midOrder(node.right);
        System.out.println("后序遍历");
    }

    // 层级遍历
    public void leverOrder() {
        leverOrder(root);
    }

    // 层级遍历
    public void leverOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node node1 = queue.remove();
            System.out.println(node1);

            if (node1.left != null) {
                queue.add(node1.left);
            }
            if (node1.right != null) {
                queue.add(node1.right);
            }

        }
    }

    // removeMax 删除二叉树中的最大值，并返回最新的根节点。
    public Node removeMax() {
        root = removeMax(root);
        return root;
    }

    public Node removeMax(Node node) {
        if (node.right == null) {
            Node newNode = node.left;
            node.left = null;
            size--;
            return newNode;
        }

        node.right = removeMax(node.right);
        return node;
    }
}
