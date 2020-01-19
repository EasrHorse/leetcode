import java.sql.SQLOutput;

/**
 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

 示例 1:

 输入: 121
 输出: true
 **/
public class LeetCode9 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
       boolean a= solution2.isPalindrome(1234321);
        System.out.println(a);
    }
}
class Solution2 {
    public boolean isPalindrome(int x) {
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }
}

