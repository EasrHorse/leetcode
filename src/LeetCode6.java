/**
 * LeetCode 第6题：将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
 P   A   H   N
 A P L S I I G
 Y   I   R
 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
 样例： 输入: s = "PAYPALISHIRING", numRows = 4
 输出: "PINALSIGYAHRPI"
 解释:
 P     I    N
 A   L S  I G
 Y A   H R
 P     I

 */
public class LeetCode6 {
    public static void main(String[] args) {
       /*
       *
        * 找规律， len = s.length()/ (2*numRows - 2) * (numRows - 1);
        * 解释一下将一个有完整列的如：PAYP这一列到ISHI这一列，有 numRows - 2个字符，加上完整的一列则为 2*numRows -2个字符
        * 而这种规律递进的行长为 numRows - 1, 当然 len ！= s.length() / 2; 计算机运算取整！！
        * 当然还有不规律的，如最后的NG这一列，其判读 otherstr = s.length()% (2*numRows - 2)
        * 判断他的列数进行相加得到最后的len
        *
       * */
        String s = "PAYPALISHIRING";
        System.out.println(convert(s,3));
    }

    public static String convert(String s, int numRows) {
        if(numRows == 1 )
            return s;
        int len = s.length() / (2*numRows - 2) * (numRows - 1);
        int otherStr = s.length() % (2*numRows - 2),otherLen = 0;
        if(otherStr != 0 ){
            if(otherStr <= numRows)
                otherLen = 1;
            else
                otherLen = otherStr - numRows + 1;
        }
        len = len + otherLen;
        char conStr[][] = new char [numRows][len];
        int k = 0 , l ,i = 0,j = 0;
        while(k < s.length()){
            //填充完整的一列
            i = 0; l = numRows;
            while(l > 0 && k < s.length()){
                conStr[i][j] = s.charAt(k);
                i++; k++; l--;
            }
            //像右推进一列，行数回归到非完整的起始行
            j++; i = numRows - 2;
            //填充非完整的列
            for(int z = numRows - 2;z > 0;z--){
                if(k < s.length()){
                    conStr[i][j] = s.charAt(k);
                    i--; j++; k++;
                }
            }
        }
        StringBuilder changedStr = new StringBuilder() ;
        for( i = 0 ; i < numRows ; i++){
            for( j = 0 ; j < len ; j++){
                if(conStr[i][j] != '\0'){
                    changedStr.append(conStr[i][j]);
                }
            }
        }
        return new String(changedStr);
    }
}