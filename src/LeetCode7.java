
public class LeetCode7 {


    public static void main(String[] args) {
        LeetCode7 leetCode7 = new LeetCode7();
        System.out.println( leetCode7.reverse(123));
    }
/*
* 用long类型变量来存储转换后的结果来判断是否越界
   由于int型数据越界之后会出现意想不到的结果，比如Integer.MAX_VALUE + 1 = 0。
* 而题目规定的数据范围内在long类型数据里怎么反转都是不会越界的，
* 因此用long类型变量来存储结果来判断是否越界即可。
* 如果越界，立即返回0；否则，在返回的时候将变量强转为int型变量返回。*/

    public  int reverse(int x) {
        boolean flag = true;
        if(x < 0) {
            x = -x;
            flag = false;
        }
        if(x == 0) {
            return 0;
        }
        while(x % 10 == 0) {
            x /= 10;
        }
        long result = 0;
        while(x > 0) {
            result = result * 10 + x % 10;
            if (result > Integer.MAX_VALUE) {
                return 0;
            }
            x /= 10;
        }
        if(flag) {
            return (int)result;
        }else {
            return -(int)result;
        }
    } }
