/*  17,电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

        给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

        示例:

        输入："23"
        输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/
/*递归做*/
import java.util.*;

public class LeetCode17 {

        //静态集合，存放的是 char 数组，用于存放 按键 → 字母 的向量
        private static List<char[]> phoneChar =  new ArrayList<char[]>();
        //静态代码块，用来初始化 phoneChar，这样集合中的元素的下标会对应其数字所代表的字符数组
        static {
            phoneChar.add(null);
            phoneChar.add(null);
            phoneChar.add(new char[]{'a','b','c'});//2
            phoneChar.add(new char[]{'d','e','f'});//3
            phoneChar.add(new char[]{'g','h','i'});//4
            phoneChar.add(new char[]{'j','k','l'});//5
            phoneChar.add(new char[]{'m','n','o'});//6
            phoneChar.add(new char[]{'p','q','r','s'});//7
            phoneChar.add(new char[]{'t','u','v'});//8
            phoneChar.add(new char[]{'w','x','y','z'});//9
        }
        //递归方法，用深搜获得全部可能。
        private void function(List<String> list, String ans, String digits, int index){
            //当递归到字符串最后一个字符时递归结束
            if(index == digits.length()){
                //将结果加入到输出集合中
                list.add(ans);
                return;
            }
            //将字符串中当前位的字符传换成 int 型的数字
            int n = Integer.parseInt(""+digits.charAt(index));
            //得到该数字对应的 char 数组
            char[] numberChar = phoneChar.get(n);
            //循环递归
            for(int i = 0; i < numberChar.length; i++){
                function(list, ans+numberChar[i], digits, index+1);
            }
        }

        public List<String> letterCombinations(String digits) {

            List<String> list = new ArrayList<String>();
            //判断空串时的特殊情况
            if(digits.equals(""))
                return list;
            function(list, "",digits, 0);

            return list;
        }

    }
