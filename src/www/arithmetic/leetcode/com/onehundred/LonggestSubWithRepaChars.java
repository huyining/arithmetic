package www.arithmetic.leetcode.com.onehundred;

import java.util.ArrayList;
import java.util.List;

/**
 * 第三题:
 * 获取字符串中不重复字符长度
 *
 * @author: huyining
 * @since :    2019-07-25
 */
public class LonggestSubWithRepaChars {

    /**
     * 3. Longest Substring Without Repeating Characters
     * <p>
     * Given a string, find the length of the longest substring without repeating characters.
     * Example 1:
     * <p>
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     * <p>
     * Input: "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     * <p>
     * Input: "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int res = 0;
        List<Character> list = new ArrayList<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            // 也就代表着lit中存在元数 就将头给删除掉  然后添加到尾
            while (list.indexOf(s.charAt(i)) >= 0) {
                list.remove(0);
            }
            list.add(c);
            res = Math.max(res, list.size());
        }

        return res;
    }

    public static void main(String[] args) {
        String str = "qrsvbspk";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
