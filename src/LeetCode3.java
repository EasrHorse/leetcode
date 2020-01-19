public class LeetCode3 {
    public static void main(String[] args) {
        /**
         * LeetCode第3题：
         * 给定一个字符串，找出不含有重复字符的最长子串的长度。
         * 示例：给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
         * 解题思路：建立指针i,j,i=0,j=i+1;最大字符长度为max
         * if str[i-(j-1)]的区间中存在 = str[j] ， i++;j=i+1;break;
         * else j++;
         * 运行时间 n的2次方
         */
        String s = "pwwkewa";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 1) return 1;
        if(s.length() == 0) return 0;
        char str[] = s.toCharArray();
        int i = 0,j = i+1,max = 0;
        boolean  t = true;
        while(i < s.length() - 1){
            int length = 1;
            //检测是否重复
            if(j == s.length()) break;
            for(int k = i; k < j;k++){
                if(str[j] != str[k] ){
                    length++;
                }else{
                    t = false;
                    break;
                }
            }
            if(length > max){
                max = length;
            }
            //如果检测成功，j指针右移一次
            if(t) j++;
                //检测失败，i指针右移一次，j指针回到i+1的位置
            else{
                t = true; i++; j = i + 1; length = 1;
            }
        }
        return max;
    }
}