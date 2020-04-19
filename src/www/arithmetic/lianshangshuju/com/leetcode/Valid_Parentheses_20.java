package www.arithmetic.lianshangshuju.com.leetcode;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 判断String有效括号
 *
 * @author : huyining
 * @since :  2020/4/19
 */
public class Valid_Parentheses_20 {

    private static Map<Character, Character> characterMap = new HashMap<>();

    static {
        characterMap.put('{', '}');
        characterMap.put('[', ']');
        characterMap.put('(', ')');
    }

    public static Boolean isValidate(String str) {

        Stack<Character> characterStack = new Stack<>();

        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (characterMap.containsKey(charAt)) {
                characterStack.push(charAt);
            } else {
                if (characterStack.isEmpty()) {
                    return false;
                }

                if (charAt != characterMap.get(characterStack.pop())) {
                    return false;
                }
            }

        }
        return characterStack.isEmpty();

    }

    public static void main(String[] args) {
        String str = "{}[]()";
        System.out.println(isValidate(str));

        String str2 = "[][}";
        System.out.println(isValidate(str2));
    }

}
