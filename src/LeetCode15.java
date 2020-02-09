/*
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

        注意：答案中不可以包含重复的三元组。

         

        示例：

        给定数组 nums = [-1, 0, 1, 2, -1, -4]，

        满足要求的三元组集合为：
        [
        [-1, 0, 1],
        [-1, -1, 2]
        ]
*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
/*首先对数组进行从小到大排序，假设这3个数的数组下标为i、j、k. 对i采用一个循环进行遍历，i:0 —>length-1；而最开始 j=i+1，k=length-1。进行下面的操作：

        如果i、j、k对应的三数之和小于0，则j+1

        如果i、j、k对应的三数之和等于0，则这三个数满足要求，将去放入集合中。并j+1、k-1

        如果i、j、k对应的三数之和大于0，则k-1*/

public  class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);      //对数组进行排序
        HashSet<List<Integer>> Res=new HashSet<>(); //创建HashSet对象
        for(int i=0;i<=nums.length-3;i++){
            if(nums[i]>0)
                break;    //若数组中的最小数大于0，直接跳出循环
            int left=i+1;  //左指针
            int right=nums.length-1;  //右指针
            while(left<right){
                int s=nums[i]+nums[left]+nums[right];//三数之和
                if(s<0){
                    left++;       //小于0，左指针右移
                }else if(s>0){
                    right--;     //大于0，右指针左移
                }else{
                    Res.add(Arrays.asList(nums[i],nums[left++],nums[right--]));    //等于0，满足条件，记录下来
                }
            }
        }
        return new ArrayList<>(Res);
    }
}