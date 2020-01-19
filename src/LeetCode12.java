/**
 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。

 示例 1:

 输入: 3
 输出: "III"
 **/
public class LeetCode12 {

    public static void main(String[] args) {
        LeetCode12 leetCode12 = new LeetCode12();
       String a= leetCode12.intToRoman(4);
        System.out.println(a);
    }
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for(int index = 0; index < nums.length && num > 0;) {//遍历nums数组来完成最终的转换
            if (num >= nums[index]) {
                sb.append(romans[index]);
                num -= nums[index];
            } else {
                index++;
            }
        }
        return sb.toString();
    }


}
