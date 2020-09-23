package www.arithmetic.lianshangshuju.com.first.binaryserachtree.printer;

/**
 * @author : huyining
 * @since :  2020/9/8
 */
public interface BinaryTreeInfo {

    /**
     * who is the  root node
     */
    Object root(Object node);

    /**
     * how to get  the  left child of the node
     */
    Object left(Object node);

    /**
     * how to get the right child of the node
     */
    Object right(Object node);

    /**
     * how to print the  node
     */
    Object string(Object node);
}
