package www.arithmetic.leetcode.com.onehundred;

import java.util.Stack;

/**
 * @author : huyining
 * @since :  2019-08-31
 */
public class Nibolan {

    /**
     * 整数除法只保留整数部分。
     * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
     * 示例 1：
     * <p>
     * 输入: ["2", "1", "+", "3", "*"]
     * 输出: 9
     * 解释: ((2 + 1) * 3) = 9
     * 示例 2：
     * <p>
     * 输入: ["4", "13", "5", "/", "+"]
     * 输出: 6
     * 解释: (4 + (13 / 5)) = 6
     * 示例 3：
     * <p>
     * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
     * 输出: 22
     * 解释:
     * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
     * = ((10 * (6 / (12 * -11))) + 17) + 5
     * = ((10 * (6 / -132)) + 17) + 5
     * = ((10 * 0) + 17) + 5
     * = (0 + 17) + 5
     * = 17 + 5
     * = 22
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

//    /**
//     * 1: 遇到运算符的话 拿到前面的俩个数字来计算  用栈
//     * 计算之后就放到栈之后 再遇到一个字符的话 就再拿出来俩个数字
//     * 弹出有操作数 弹出左操作数
//     */
//    public int evalRPN(String[] tokens) {
//        Stack<Integer> stakeInteger = new Stack<>();
//        for (String token : tokens) {
//            // 是符号吗?
//            if (isOperator(token)) {
//                // pop方法有前后  写到方法中注意下pop的是那个
//                Integer right = stakeInteger.pop();
//                Integer left = stakeInteger.pop();
//                stakeInteger.push(calculate(right , left, token));
//
//            } else {
//                stakeInteger.push(Integer.parseInt(token));
//            }
//        }
//        return stakeInteger.pop();
//    }


//    public int evalRPN(String[] tokens) {
//        Stack<Integer> stakeInteger = new Stack<>();
//        for (String token : tokens) {
//
//            stakeInteger.push(isOperator(token) ? calculate(stakeInteger.pop(),
//                    stakeInteger.pop(), token) : Integer.parseInt(token));
//        }
//        return stakeInteger.pop();
//    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stakeInteger = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stakeInteger.push(stakeInteger.pop() + stakeInteger.pop());
                    break;
                case "*":
                    stakeInteger.push(stakeInteger.pop() * stakeInteger.pop());
                    break;
                case "-":
                    stakeInteger.push(-stakeInteger.pop() + stakeInteger.pop());
                    break;
                case "/":
                    Integer right = stakeInteger.pop();
                    stakeInteger.push(stakeInteger.pop() / right);
                    break;
                default:
                    stakeInteger.push(Integer.parseInt(token));
                    break;
            }
        }
        return stakeInteger.pop();
    }

    /**
     * 判断是不是字符
     *
     * @param token
     * @return
     */
    private boolean isOperator(String token) {
        return "+-*/".contains(token);
    }

    /**
     * 计算
     */
    private int calculate(Integer right, Integer left, String operator) {
        switch (operator) {
            case "+":
                return left + right;
            case "*":
                return left * right;
            case "-":
                return left - right;
            default:
                return left / right;
        }
    }


}
