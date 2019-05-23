package com.xl.leetcode;

public class MedianOfTwoSortedArray {

    /**
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     *
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     *
     * 你可以假设 nums1 和 nums2 不会同时为空。
     *
     * 示例 1:
     *
     * nums1 = [1, 3]
     * nums2 = [2]
     *
     * 则中位数是 2.0
     * 示例 2:
     *
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     *
     * 则中位数是 (2 + 3)/2 = 2.5
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N1 = nums1.length;
        int N2 = nums2.length;
//        保持num1的数组更短，最终时间复杂度就为log(min(N1,N2))
        if(N1>N2)
            return findMedianSortedArrays(nums2,nums1);
//        如果nums1数组长度为0，则直接取num2数组中位数
        if(N1==0)
//            如果是奇数长度，就是两个相同的中间数之和/2，如果是偶数，就是两个不同的中间数/2
            return ((double)nums2[(N2-1)/2]+(double)nums2[N2/2])/2;
        int size = N1+N2;
//        使用二分法切分nums1，每次切分范围是cutL-cutR
       int cutL = 0;
       int cutR = N1;
//       nums1切分的位置，也就是切分位置左边数个数，也是num1拿出来的放在两个数组合成后的有序数组的左半边的那些数
        int cut1 = 0;
//        nums2切分位置，应该是合并后的有序数组的左半边的数个数-num1拿出来放在左半边的那些数个数
        int cut2 = size/2 - cut1;
//        只要num1切分位置不大于它的长度，而且没有切到合适的位置就继续切分
        while (cut1<=N1){
//            num1每次的切分位置是切分范围的中间位置
            cut1 = cutL + (cutR-cutL)/2;
            cut2 = size/2 - cut1;
//            L1，L2分别是num1和nums2中切分位置左边的那个数
//            如果nums1或者nums2中的数都应该放在合并后的有序数组的右半边，则临时给L1或L2赋值为最小值，因为下面比较要用
            double L1 = (cut1==0)?Integer.MIN_VALUE:nums1[cut1-1];
            double L2 = (cut2==0)?Integer.MIN_VALUE:nums2[cut2-1];
//            R1，R2分别是num1和nums2中切分位置的那个数
//            如果nums1或者nums2中的数都应该放在合并后的有序数组的左半边，则临时给L1或L2赋值为最大值，因为下面比较要用
            double R1 = (cut1==N1)?Integer.MAX_VALUE:nums1[cut1];
            double R2 = (cut2==N2)?Integer.MAX_VALUE:nums2[cut2];
//            切分完，判断切分位置是否正确
//            若切分后，左边值存在比右边大的，则继续切分，缩小范围
            if(L1>R2){
//                若L1>R2,则说明nums1左边的值大了，切分位置应该向左移，切分的数要更小
                cutR = cut1 - 1;
            }else if(L2>R1){
//                若L2>R1,则说明nums1右边的值小了，切分位置应该向右移，切分的数要更大
                cutL = cut1 + 1;
            }else {
//                否则，就是切分正确
//                若合并后的有序数组个数为偶数
                if(size%2==0){
//                    L1和L2之间更大的那个数才是合并后的有序数组的两个中间数之一
                    L1 = L1>L2?L1:L2;
//                    R1和R2之间更小的那个数才是合并后的有序数组的两个中间数之一
                    R1 = R1<R2?R1:R2;
                    return (L1+R1)/2;
                }else {
//                    若合并后的有序数组个数为奇数，则R1和R2中更小的那个数就是中间数
                    R1 = R1<R2?R1:R2;
                    return R1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {3,5,8,9,15};
        int[] nums2 = {1,2,7,10,11,12};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

}
