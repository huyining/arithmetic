package www.arithmetic.mashibing.com;

import java.util.Arrays;
import java.util.Random;

/**
 * 对数器
 *
 * @author: huyining
 * @since :    2019-04-13
 */
public class DataChecker {

    static int[] generateRandomArray() {

        Random random = new Random();
        int[] arr = new int[1000];

        for (int a = 0; a < arr.length; a++) {
            arr[a] = random.nextInt(1000);
        }

        return arr;
    }

    static void checker() {
        int[] arr = generateRandomArray();
        int[] arr1 = new int[arr.length];
        System.arraycopy(arr, 0, arr1, 0, arr.length);

        Arrays.sort(arr);
        BubboSort.sort(arr1);

        Boolean same = true;
        for (int i = 0; i < arr1.length; i++) {
            if (arr[i] != arr1[i]) {
                same = false;
            }
            System.out.println(same == true ? "right" : "wrong");
        }
    }

    public static void main(String[] args) {
        checker();
    }
}
