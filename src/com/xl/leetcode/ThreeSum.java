package com.xl.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//三数之和
public class ThreeSum {

    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
//        先将数组排序，有可能会存在多个相等的数连续
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
//
        for(int i=0;i<nums.length-2;i++){
//          若是第一个数，或者这个数和前一个数不等，才计算，为了去重
            if(i==0||(i>0&&nums[i]!=nums[i-1])){
//                左右两个指针，左边从当前数的下一个数开始向后，右边从最后一个数开始向前，
//                 以当前数为基数，sum为可以与当前数相加为0的两个数之和
                int l = i+1,r = nums.length-1,sum = -nums[i];
//                当左指针不超过右指针时
                while(l<r){
//                    若左右两个指针的数等于sum，则找到了一组
                    if(nums[l]+nums[r]==sum){
//                        加入结果集中
                        result.add(Arrays.asList(nums[i],nums[l],nums[r]));
//                       找到了这一个三元组，那么再有相同的这两个数组合就要去掉，左指针向后移动到不等的数
                        while(l<r&&nums[l]==nums[l+1])
                            l++;
//                        右指针同样向前移动到不等的数
                        while(l<r&&nums[r]==nums[r-1])
                            r--;
//                        上面两个指针移动，最终停留的位置，是这一组相同数的最后一个，再移动一个才是不同的数
                        l++;
                        r--;
                    }else if(nums[l]+nums[r]<sum){
//                        若两数之和小于sum，说明数取小了，则左指针继续向后移动，且移动到不等的数
                        while(l<r&&nums[l]==nums[l+1])
                            l++;
                        l++;
                    }else{
//                        若两数之和大于sum，说明数取大了，则右指针继续向前移动，移动到不等的数
                        while(l<r&&nums[r]==nums[r-1])
                            r--;
                        r--;
                    }
                }
            }
        }
        return result;
    }

}
