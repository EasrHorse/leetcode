/*  20.有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

        有效字符串需满足：

        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        注意空字符串可被认为是有效字符串。
        示例 1:
        输入: "()"
        输出: true

        输入: “()[]{}”
        输出: true
        示例 3:
        输入: “(]”
        输出: false
        示例 4:

        输入: “([)]”
        输出: false
        示例 5:

        输入: “{[]}”
        输出: true
*/

import java.util.Stack;
/*遇到左括号就进栈；

        遇到右括号，就判断栈顶元素是否与之匹配，匹配的话就pop出栈，不匹配的话就返回false*/
public class LeetCode20 {
    public static boolean isValid(String s) {
        if (s.isEmpty())
            return true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}