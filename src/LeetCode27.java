/*27. 移除元素
给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
        不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
        元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
        示例 1:
        给定 nums = [3,2,2,3], val = 3,
        函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
        你不需要考虑数组中超出新长度后面的元素。
        示例 2:
        给定 nums = [0,1,2,2,3,0,4,2], val = 2,
        函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
        注意这五个元素可为任意顺序。
        你不需要考虑数组中超出新长度后面的元素。*/
public class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;    //*注意right指针移动过程
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];   //**
                right--;    //赋值后left不变，需要再经历一次判断，防止交换过来的值也等于val
            } else {
                left++;
            }
        }
        return right;  //***
    }
}