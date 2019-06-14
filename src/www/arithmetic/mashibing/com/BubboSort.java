package www.arithmetic.mashibing.com;

/**
 * 冒泡排序
 *
 * @author: huyining
 * @since :    2019-04-13
 */
public class BubboSort {


    public static void main(String[] args) {
        int[] arr = {9, 3, 4, 5, 7, 8, 2, 1, 0};
        sort(arr);
        printl(arr);

    }


    /**
     * 排序
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            findMax(arr, i);
        }


    }

    /**
     * 找出最大的元素
     *
     * @param arr 数组
     * @param n   数组最大位置的索引
     */
    private static void findMax(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }
    }


    /**
     * 交换
     *
     * @param arr 数组
     * @param a   前一个数据索引
     * @param b   后一个数据索引
     */
    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }

    /**
     * 打印数组
     *
     * @param arr
     */
    private static void printl(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "");
        }
    }

}
