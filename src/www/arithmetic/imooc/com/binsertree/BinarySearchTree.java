package www.arithmetic.imooc.com.binsertree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二分查找树
 *
 * @author: huyining
 * @since :    2019-08-05
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private class Node {

        public E e;

        public Node left;

        public Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加节点
     *
     * @param e
     */
    public void add(E e) {
        if (root == null) {
            this.root = new Node(e);
            size++;
        } else {
            add(root, e);
        }

    }


    /**
     * 二分查找树添加节点
     *
     * @param node
     * @param e
     */
    private void add(Node node, E e) {
        if (e.equals(node.e)) {
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

        if (e.compareTo(node.e) < 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }
    }

    /**
     * 判断是否包含莫个节点
     *
     * @param e
     * @return
     */
    private boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 判断是否包含莫个元素
     *
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 二分查找树的前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 递归实现树的遍历, 深度优先   遍历
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }


    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后续遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后续遍历
     *
     * @param node
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }


    /**
     * 链表的广度优先
     */
    public void levelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.println(node.e);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    /**
     * 获取最小节点数数据
     *
     * @return
     */
    public E minimum() {
        if (root == null) {
            throw new IllegalArgumentException("BinarySearchTree is empty.....");
        }

        Node node = minimum(root);
        return node.e;
    }

    /**
     * 获取最小节点的Node
     *
     * @param node
     * @return
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }


    /**
     * 获取最大节点的元素
     *
     * @return
     */
    public E maxmum() {
        if (root == null) {
            throw new IllegalArgumentException("BinarySearchTree  is empty....");
        }
        return maxmum(root).e;
    }

    /**
     * 获取二分查找树中祖代的元素
     *
     * @param node
     * @return
     */
    private Node maxmum(Node node) {
        if (node.right == null) {
            return node;
        }

        return maxmum(node.right);
    }

    /**
     * 删除树中最小值 并返回删除的元素
     *
     * @return
     */
    public E removeMin() {
        E e = minimum();
        root = removeMin(root);
        return e;
    }

    /**
     * 删除书中最小值 返回删除节点后新的二分收索树的根
     *
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        //  最小值在左边
        if (node.left == null) {
            // 如果没有最小值的化 有右节点的话 拿到右节点
            // 右节点设置为null  返回拿到的右节点 作为新原来节点的左节点
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除树中最大值  并返回删除的元素
     *
     * @return
     */
    public E removeMax() {
        E e = maxmum();
        root = removeMax(root);
        return e;
    }

    /**
     * 删除树中最大值
     *
     * @param node
     * @return
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除元素为E的节点
     *
     * @param e
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除元数为E的节点
     * 返回删除节点后新的节点的根
     *
     * @param node
     * @param e
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }

        // node.e要大于e, 所以像node的左边进行遍历
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        }
        // 当前的节点要比查找的元素小 就往右找
        else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        }

        // 删除的节点和当前节点相等
        // 判断是否有左右子节点
        else {
            // 如果待删除的节点左子树为空的话
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // 如果待删除的节点右子树为空的话
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 当待删除的节点的左右节点都不为空的情况下
            // 找到比待删除节点大的最小节点, 然后代替当前节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return  successor;
        }
    }

    /**
     * 打印二分树
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     */
    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }


    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }


}
