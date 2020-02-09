/*22. 括号生成
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

        例如，给出 n = 3，生成结果为：

        [
        "((()))",
        "(()())",
        "(())()",
        "()(())",
        "()()()"
        ]*/

import java.util.*;

/*n对括号，n个左括号为left，n个右括号right，当left ！= 0时，递归left-- path+“（”，
        当rigth！==&&right>left时，递归right-- path+“）”，直到left==0&&right==0时，将path添加到list中。

        也就是说当左括号个数不为0时，可以添加左括号，右括号个数不为0并且大于左括号个数时，添加右括号。
      */
public class LeetCode22 {
        public List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            doadd(n, n, list, "");
            return list;
        }

        public static void doadd(int left, int right, List<String> list, String path) {

            if (left == 0 && right == 0) {
                list.add(path);
                return;
            }
            if (left != 0)
                doadd(left - 1, right, list, path + "(");
            if (right != 0 && right > left)
                doadd(left, right - 1, list, path + ")");
        }

    }
