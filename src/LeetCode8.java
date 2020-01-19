/**
 * ----------------------字符串转整数---------------
 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。

 示例 1:

 输入: "42"
 输出: 42

 **/
public class LeetCode8 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
       int a= solution1.myAtoi("-1234");
        System.out.println(a);
    }
}
class Solution1 {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty()) return 0;
        // 正负号标记
        int sign = 1;
        // 转换值
        int base = 0;
        // 索引位数
        int i = 0;
        // 判断正负号
        if (str.charAt(i) == '-' || str.charAt(i) == '+')
            sign = str.charAt(i++) == '-' ? -1 : 1;
        // 索引有效数字字符
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            // 如果base > MAX_VALUE/10，那么base*10 + new_value > base*10 > MAX_VALUE，这种情况下就会发生溢出。
            // 若base == INT_MAX/10，而且new_value = str.charAt(i++) - '0'`大于`7`，也会发生溢出。因为MAX_VALUE = 2147483647
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // 计算转换值
            base = 10 * base + (str.charAt(i++) - '0');
        }
        // 计算结果值
        return base * sign;
    }
}
