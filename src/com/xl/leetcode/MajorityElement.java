package com.xl.leetcode;

//求众数
public class MajorityElement {

    /**
     * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在众数。
     *
     * 示例 1:
     *
     * 输入: [3,2,3]
     * 输出: 3
     * 示例 2:
     *
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
//        当前数字的出现个数
        int count = 1;
        int result = nums[0];
        for (int i=1;i<nums.length;i++){
//            遍历数组，若数组该位置的数与当前数相等
            if(nums[i]==result){
//                则当前数出现次数加1
                count++;
            }else {
//                否则，当前数次数减1
                count--;
//                若当前数次数为0了
                if(count==0){
//                    则切换到下一个数作为当前数继续比较
//                    这样最后剩下的肯定是出现次数最多的数
                    result = nums[i+1];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

}
