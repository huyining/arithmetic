package www.arithmetic.leetcode.com.onehundred;

/**
 * LeetCode第五题
 * 本地测试能够通过 提交代码测试的时间过不去
 *
 * @author: huyining
 * @since :    2019-07-31
 */
public class LongestPalinSubstring {

    /**
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     * <p>
     * Example 1:
     * <p>
     * Input: "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     * Example 2:
     * <p>
     * Input: "cbbd"
     * Output: "bb"
     */

    /**
     * 使用二分法找出回文字符串
     * 这中间有单数回文和双数回文
     */
    static String res = "";

    public static String longestPalind(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            /**
             *  处理 Input: "babad"
             *      Output: "bab"
             */
            helper(s, i, i);
            helper(s, i, i + 1);
        }

        return res;
    }

    /**
     * 寻找回文字符串
     *
     * @param s
     * @param left
     * @param right
     */
    private static void helper(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        String cur = s.substring(left + 1, right);
        if (cur.length() > res.length()) {
            res = cur;
        }
    }

    public static void main(String[] args) {
        String palind = longestPalind("cbbd");
        System.out.println(palind);

    }

}
