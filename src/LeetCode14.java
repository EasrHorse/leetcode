/**
 编写一个函数来查找字符串数组中的最长公共前缀。
 如果不存在公共前缀，返回空字符串 ""。
 示例 1:
 输入: ["flower","flow","flight"]
 输出: "fl"
 示例 2:
 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。
 说明:
 所有输只包含小写字母 a-z 。
 **/
public class LeetCode14 {
    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        String[] a={"flower","flow","flight"};
       String b= solution14.longestCommonPrefix(a);
        System.out.println(b);
    }
}
class Solution14 {//思路：①先遍历字符串数组，找出长度最短的那个子串。
          // ②以最短的子串作为基准，在此遍历字符串数组，找出最长前缀
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String re="";
        int index=0;
        int length=strs[0].length();
        //找出最短长度的字符串
        for(int i=0;i<strs.length-1;i++){
            if(length>strs[i].length()){
                length=strs[i].length();
                index=i;
            }
        }
        //以最短子串为基准，在此遍历字符串数组，找出最长前缀
        out:for(int i=1;i<=length;i++){
            String sub=strs[index].substring(0, i);
            for(int j=0;j<strs.length;j++){
                if(!strs[j].startsWith(sub)){
                    break out;
                }
            }
            re=sub;
        }
        return re;
    }
}