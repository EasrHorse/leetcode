/*
26. 删除排序数组中的重复项
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

        不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

        示例 1:

        给定数组 nums = [1,1,2],

        函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

        你不需要考虑数组中超出新长度后面的元素。
        示例 2:

        给定 nums = [0,0,1,1,1,2,2,3,3,4],

        函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

        你不需要考虑数组中超出新长度后面的元素。
*/
/*采用两个标记点 number 和 i ，number记录不重复元素的位置，
        i从number的下一个开始遍历数组，如果i位置的数字等于number位置的数字，
        说明该数字重复出现，不予处理；如果i位置的数字不等于number位置的数字，
        说明该数字没有重复，需要放到l的下一位置，并使number加1。*/


public class LeetCode26 {

        public static void main(String[] args) {
            LeetCode26 lt = new LeetCode26();
            int []num = {0,1,1,2,2,3,3,4};
            System.out.println(lt.removeDuplicates(num));
        }

        // 扔进去AC了他
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0)
                return 0;
            //判断无输入
            int number = 0;//标记计数
            for (int i=0; i < nums.length ; i++) {
                if ( nums[i] != nums[number] ) {
                    number++;
                    nums[number] = nums[i];
                }
            }
            number+=1; //标记+1即为数字个数
            return number;
        }

    }