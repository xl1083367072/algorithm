package com.xl.leetcode;

public class ReverseInteger {

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     *
     * 输入: 123
     * 输出: 321
     *  示例 2:
     *
     * 输入: -123
     * 输出: -321
     * 示例 3:
     *
     * 输入: 120
     * 输出: 21
     * @param x
     * @return
     */
    public static int reverse(int x) {
//        结果可能溢出，所以用long存储
        long result = 0;
        while (x!=0){
//            思想是，每次截取最后一个数字，加到结果的最后面，所以结果每次乘10再加上截取的一位数字
            result = result*10 + x%10;
            x /= 10;
//            若当前产生的结果溢出了，则返回0
            if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE)
                return 0;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        int num = 0x7fffffff;
        System.out.println(reverse(num));
        System.out.println(Integer.MAX_VALUE);
    }
}
