package www.arithmetic.leetcode.com.onehundred;

/**
 * 第九题: 回文数字
 *
 * @author: huyining
 * @since :    2019-08-05
 */
public class PalindromeNumber {

    public static  boolean isPalindrom(int number) {
        if (number < 0 || (number != 0 && number % 10 == 0)) {
            return false;
        }
        int palind = number;
        int rev = 0;
        while (number > 0) {
            // 取模获取到余数 也就是各位上的数字
            rev = rev * 10 + number % 10;

            // 取整 也就是获取到十位之前的数字
            number /= 10;
        }

        return palind == rev;
    }

    public static void main(String[] args) {
        int  number = 100;
        System.out.println(isPalindrom(number));
    }

}
