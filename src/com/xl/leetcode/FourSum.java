package com.xl.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//四数之和
public class FourSum {

    /**
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     *
     * 注意：
     *
     * 答案中不可以包含重复的四元组。
     *
     * 示例：
     *
     * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
     *
     * 满足要求的四元组集合为：
     * [
     *   [-1,  0, 0, 1],
     *   [-2, -1, 1, 2],
     *   [-2,  0, 0, 2]
     * ]
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
//        第一层
        for (int i=0;i<nums.length-3;i++){
//          去重
            if(i>0&&nums[i]==nums[i-1])
                continue;
//            第二层
            for (int j=i+1;j<nums.length-2;j++){
//                去重
                if(j>i+1&&nums[j]==nums[j-1])
                    continue;
//                三数之和的核心，左右指针遍历
                int left = j+1,right = nums.length-1;
                while (left<right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum==target){
                        lists.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
//                        去重
                        while (left<right&&nums[left]==nums[left+1])
                            left++;
//                        去重
                        while (left<right&&nums[right]==nums[right-1])
                            right--;
//                        继续向后移动
                        left++;
                        right--;
                    }else if(sum<target){
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(nums,0));
    }

}
