import java.util.*;

/*18.四数之和
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d
 ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

        注意：

        答案中不可以包含重复的四元组。

        示例：

        给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

        满足要求的四元组集合为：
        [
        [-1,  0, 0, 1],
        [-2, -1, 1, 2],
        [-2,  0, 0, 2]
        ]*/
public class LeetCode18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        /**
         * 双双指针法
         */
        List<List<Integer>> lists = new ArrayList<>();
        //对传进来的排序哈
        Arrays.sort(nums);
        //第一次定个值
        for (int i = 0; i < nums.length - 3; i++) {
            if (!lists.isEmpty() && nums[i] == nums[i - 1])
            //去重条件去除第一个数找到满足条件的，那么下一个数可以跳过  重点
            //!lists.isEmpty()这去除第一个
            {
                continue;
            }
            //第二次定个值
            for (int j = i + 1; j < nums.length - 2; j++) {
                //下面去重就得改变哈添加j-1!=i，这条件去掉的是本身i与i-1或是j与j-1的比较对应的nums重复值
                if (!lists.isEmpty() && nums[j] == nums[j - 1] && j - 1 != i) {
                    continue;
                }
                //后面定义两个指针移动
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    int ans = nums[i] + nums[j] + nums[start] + nums[end];
                    if (ans == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        lists.add(list);
                        start++;
                        end--;
                        //去重
                        while ((nums[start] == nums[start - 1]) && start < end) {
                            start++;
                        }

                        while ((nums[end] == nums[end + 1]) && start < end) {
                            end--;
                        }
                    } else if (ans < target && start < end) {
                        start++;
                        continue;
                    } else {
                        end--;
                        continue;
                    }

                }
            }
        }
        return lists;
    }
}
