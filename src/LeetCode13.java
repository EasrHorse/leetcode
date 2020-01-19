/**
 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。

 示例 1:

 输入: "III"
 输出: 3
 **/
public class LeetCode13 {
    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
int a=solution13.romanToInt("XIX");
        System.out.println(a);
    }
}
    class Solution13 {//依旧采取遍历实现
        public int romanToInt(String s) {
            if(s=="")  return 0;
            int ans=0,j=0;
            int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL",
                    "X", "IX", "V", "IV", "I"};
            //if(romans[12].equals(""+s.charAt(0))) return 2;
            for(int i=0;i<13 && j<s.length();) {
                if(romans[i].equals(""+s.charAt(j)) ){
                    ans=ans+nums[i];
                    j++;
                }
                else if(j<s.length()-1 && romans[i].equals(""+s.charAt(j)+s.charAt(j+1))){
                    ans=ans+nums[i];
                    i++;
                    j+=2;
                }
                else{
                    i++;
                }
            }
            return ans;
        }
    }
