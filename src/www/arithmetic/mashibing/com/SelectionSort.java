package www.arithmetic.mashibing.com;

/**
 * 选择排序
 *
 * @author: huyining
 * @since :    2019-04-18
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {5, 8, 9, 3, 2, 1, 6, 7};

        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;

            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }
            swap(arr,i,minPos);
        }

        printArray(arr);

    }


    /**
     * 数据交换
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    private static void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "");
        }
    }
}
