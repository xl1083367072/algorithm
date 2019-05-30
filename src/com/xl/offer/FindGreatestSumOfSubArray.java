package com.xl.offer;

public class FindGreatestSumOfSubArray {

    /**
     * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
     * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,
     * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
     * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
     * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
     * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array==null||array.length==0)
            return 0;
//        记录当前和
        int curr = 0;
//        记录最大和
        int max = Integer.MIN_VALUE;
        for (int i=0;i<array.length;i++){
//            当前面累加和小于0，那么就舍弃前面的，因为，加上前面的只会使后面的和变小
            if(curr<=0)
                curr = array[i];
//            否则，继续进行累加
            else
                curr += array[i];
//            若当前累加和大于最大和，重新定义最大和
            if(curr>max)
                max = curr;
        }
        return max;
    }

}
