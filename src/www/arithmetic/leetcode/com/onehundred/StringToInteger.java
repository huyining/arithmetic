package www.arithmetic.leetcode.com.onehundred;

/**
 * 第8题: 字符串转换成数字
 *
 * @author: huyining
 * @since :    2019-08-05
 */
public class StringToInteger {

    public static int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) {
            return 0;
        }

        char firstChar = str.charAt(0);
        int sign = 1;
        int start = 0;
        long res = 0;
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }

        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) res * sign;
            }
            res = res * 10 + str.charAt(i) - '0';
            if (sign == 1 && res > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && res > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }

        }
        return (int) res * sign;
    }

    public static void main(String[] args) {
        String str1 = "23dev";
        System.out.println(StringToInteger.myAtoi(str1));
        String str2 = "-91283472332";
        System.out.println(StringToInteger.myAtoi(str2));
        String str3 = "+23dev";
        System.out.println(StringToInteger.myAtoi(str3));
    }

}
