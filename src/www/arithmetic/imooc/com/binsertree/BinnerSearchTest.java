package www.arithmetic.imooc.com.binsertree;

/**
 * @author: huyining
 * @since :    2019-08-06
 */
public class BinnerSearchTest {

    public static void main(String[] args) {

        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        // bst.preOrder();
        System.out.println();

        // bst.inOrder();
        System.out.println();

        // bst.postOrder();
        System.out.println();

        // bst.levelOrder();
        System.out.println();

        // Integer minimum = bst.minimum();
        // System.out.println(minimum);


        // Integer maxmum = bst.maxmum();
        //System.out.println(maxmum);

        Integer removeMax = bst.removeMax();
        System.out.println(removeMax);
        System.out.println(bst);
    }
}
