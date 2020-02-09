/*28.实现 strStr() 函数。

        给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

        示例 1:

        输入: haystack = "hello", needle = "ll"
        输出: 2
        */

public class LeetCode28 {
        public int strStr(String haystack, String needle) {
            //当needle为空则返回0
            if(needle.equals(""))
                return 0;

            int len = needle.length();
            //查看haystack字符串是否包含有needle字符串
            for(int i=0; i<haystack.length()-len+1;i++) {
                if(haystack.substring(i, i+len).equals(needle)) {
                    return i;
                }
            }
            return -1;
        }

}
