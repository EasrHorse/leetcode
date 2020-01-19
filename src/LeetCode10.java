import com.sun.org.apache.bcel.internal.generic.NEW;

/**  正则表达式
 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

 '.' 匹配任意单个字符
 '*' 匹配零个或多个前面的那一个元素

 输入:
 s = "aa"
 p = "a"
 输出: false
 解释: "a" 无法匹配 "aa" 整个字符串。
 **/
public class LeetCode10 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
     boolean a=   solution3.isMatch("aa", "a*");
        System.out.println(a);
    }
}
class Solution3 {
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();//判断是否都为空
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));//第一个字符串不为空，并且第一个字母相同或p字符串首字母为点
//判断p字符串长度和第二个字符
        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}


