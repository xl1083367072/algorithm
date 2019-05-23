package com.xl.leetcode;

import java.util.Arrays;

//最接近目标值的三数之和
public class ThreeSumCloest {

    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     *
     * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
     *
     * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
//        先取个初值
        int result = nums[0] + nums[1] + nums[2];
//        这种类型题目，因为要从两边向中间移动，所以都要排序
        Arrays.sort(nums);
//        最后面两个数不能组成三元组
        for (int i=0;i<nums.length-2;i++){
//            左右指针
            int left = i+1,right = nums.length-1;
            while (left<right){
//                取当前三数之和
                int temp = nums[i] + nums[left] + nums[right];
//                若大于目标值，则右指针前移
                if(temp>target)
                    right--;
//                若小于目标值，则左指针后移
                else
                    left++;
//                若当前三数之和小于当前结果，即更接近目标值，就保留
                if(Math.abs(temp-target)<Math.abs(result-target))
                    result = temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        System.out.println(threeSumClosest(nums,2));
    }

}
