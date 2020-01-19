/**
 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

 示例 1：

 输入: "babad"
 输出: "bab"
 注意: "aba" 也是一个有效答案。
 **/


    public class LeetCode5 {
        public static void main(String[] args) {
            /**
             *定义i,j两个指针，起始i=k-1或者k,j=k+1;
             * 假设回文子串为长度偶数的中位为k=0，如果nums[i]!=nums[j],则k++;
             * 否则 if i >= 0 , i--,j++,再次判断，直到不成立此时子串长度为 j-i-1;
             *
             *
             */
            String s = "09abcddcba";
            System.out.println(longestPalindrome(s));

        }

        public static String longestPalindrome(String s) {
            int max = 1 , mid = 0; //记录中位
            int i,j,k = 0;
            //回文子串为偶数
            while(k < s.length()- 1){
                i = k; j = k + 1;
                while(i >= 0 &&  j < s.length() && compareNumber(i,j,s) ){
                    compareNumber(i,j,s) ;
                    i--;j++;
                }
                //i多减了一次，j多加了一次
                int len = j - i - 1;
                if(len > max){
                    max = len;
                    mid = k;
                }
                k++;
            }
            k = 1;
            //回文子串为奇数
            while(k < s.length() - 1){
                i = k - 1; j = k + 1;
                while( i >= 0 &&  j < s.length() && compareNumber(i,j,s) ){
                    compareNumber(i,j,s) ;
                    i--;j++;
                }
                int len = j - i - 1;
                if(len > max){
                    max = len;
                    mid = k;
                }
                k++;
            }
            if(max % 2 == 0){
                return s.substring(mid - max / 2 + 1, mid + max / 2 +1);
            }else{
                return s.substring(mid - max / 2  , mid + max / 2 + 1);
            }
        }

        public static boolean compareNumber(int i , int j, String s){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            return true;
        }
    }