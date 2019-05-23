package com.xl.leetcode;

public class ContainerWithMostWater {

    /**
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int result = 0;
//        从左边开始的线
        int L = 0;
//        从右边开始的线
        int R = height.length - 1;
        while (L<R){
//            两条线围成的容器面积，高取决于哪个线更短
            result = Math.max(result,Math.min(height[L],height[R])*(R-L));
//            哪根线更短，哪边就移动到下一条
            if(height[L]<height[R])
                L++;
            else
                R--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

}
