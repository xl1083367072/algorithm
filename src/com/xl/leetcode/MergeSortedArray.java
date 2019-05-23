package com.xl.leetcode;

import java.util.Arrays;

//合并有序数组
public class MergeSortedArray {

    /**
     *
     给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

     说明:

     初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     示例:

     输入:
     nums1 = [1,2,3,0,0,0], m = 3
     nums2 = [2,5,6],       n = 3

     输出: [1,2,2,3,5,6]
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
//    思想：合并后的数组长度是m+n,那么nums1和nums2中最大值就应该放在最后位置上
//    次大的放在次后位置上，如此往复比较
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        计算合并后最会一个元素下标
        int p = m--+n---1;
//        当m，n都不为0，即可以比较时
        while (m>=0&&n>=0){
//            两个数组分别从最后一个元素开始比较，哪个更大哪个就放在当前p的位置上，并且向前移动一位
            nums1[p--] = nums1[m]>nums2[n]?nums1[m--]:nums2[n--];
        }
//        若n还有元素，则将n中的元素从大到小依次放入nums1中就可以了
        while (n>=0){
            nums1[p--] = nums2[n--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }

}
