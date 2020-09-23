package www.arithmetic.lianshangshuju.com.first.binaryserachtree;

import com.sun.deploy.net.DownloadException;
import www.arithmetic.lianshangshuju.com.first.binaryserachtree.printer.BinaryTreeInfo;

import java.util.Comparator;

/**
 * @author : huyining
 * @since :  2020/9/8
 */
public class BinarySearchTree<E> implements BinaryTreeInfo {

    private int size;
    private Node<E> root;
    private Comparator<E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    /**
     * 获取元素的数量
     *
     * @return 元素的个数
     */
    public int size() {
        return size;
    }

    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 清空所有元素
     */
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * 添加元素
     *
     * @param element
     */
    public void add(E element) {
        elementNotNullCheck(element);

        // 第一个节点的添加
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }

        //  如果添加的不是第一个节点的话  就需要不断的遍历找到对应的节点
        Node<E> parent = root;
        Node<E> node = root;
        int cmp = 0;

        do {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                node.element = element;
                return;
            }

        } while (node != null);

        // 看看新的节点插入数据库什么位置

        Node<E> newNode = new Node<>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }

        size++;
    }

    /**
     * 等于0  代表俩个值相等  大于0  代表e1  大于e2  小于0 代表 e1 小于 e2
     */
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }

        return ((Comparable<E>) e1).compareTo(e2);
    }

    /**
     * 删除元素
     *
     * @param element
     */
    public void remove(E element) {


    }

    /**
     * 是否包含莫个元素
     *
     * @param element 元素
     * @return 判断结果
     */
    public boolean contains(E element) {
        return false;
    }


    public static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
        }
    }


    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element  must not  null");
        }

    }

    /**
     * who is the  root node
     *
     * @param node
     */
    @Override
    public Object root(Object node) {
        return root;
    }

    /**
     * how to get  the  left child of the node
     *
     * @param node
     */
    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    /**
     * how to get the right child of the node
     *
     * @param node
     */
    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    /**
     * how to print the  node
     *
     * @param node
     */
    @Override
    public Object string(Object node) {
        Node<E> myNode = (Node<E>) node;
        String parentString = "null";
        return myNode.element + "_p(" + parentString + ")";
    }
}
