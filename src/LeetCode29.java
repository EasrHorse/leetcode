/*29. 两数相除

        给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
        返回被除数 dividend 除以除数 divisor 得到的商。
        示例 1:

        输入: dividend = 10, divisor = 3
        输出: 3
        示例 2:

        输入: dividend = 7, divisor = -3
        输出: -2*/
/*   被除数和除数均为 32 位有符号整数。
           除数不为 0。
           假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。*/
/*
 *      1. 累加被除数，知道大于除数
 *
 *　　  2.（网上资源）  任何一个整数可以表示成以2的幂为底的一组基的线性组合，
 *      即num=a_0*2^0+a_1*2^1+a_2*2^2+…+a_n*2^n。
 *      基于以上这个公式以及左移一位相当于乘以2，
 *      我们先让除数左移直到大于被除数之前得到一个最大的基。
 *      然后接下来我们每次尝试减去这个基，如果可以则结果增加加2^k,然后基继续右移迭代，直到基为0为止。
 *      因为这个方法的迭代次数是按2的幂知道超过结果，所以时间复杂度为O(log(n))。

 */

public class LeetCode29 {
    public int divide(int dividend, int divisor) {
        // 相除时溢出处理
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // 求符号位
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        // 求绝对值，为防止溢出使用long
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        // 记录结果
        int result = 0;

        // 被除数大于除数
        while (dvd >= dvs) {
            // 记录除数
            long tmp = dvs;
            // 记录商的大小
            long mul = 1;

            while (dvd >= (tmp << 1)) {
                tmp <<= 1;
                mul <<= 1;
            }

            // 减去最接近dvd的dvs的指数倍的值（值为tmp）
            dvd -= tmp;

            // 修正结果
            result += mul;
        }

        return result * sign;
    }
}


