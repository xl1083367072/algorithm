package com.xl.offer;

//丑数
public class GetUglyNumber {

    /**
     * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
     * 例如6、8都是丑数，但14不是，因为它包含质因子7。
     * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
//        前六个是1,2,3,4,5,6
        if(index<7)
            return index;
//        存放前index个丑数
        int[] uglyNumbers = new int[index];
//        后面的丑数是前面丑数乘以2,3或5得来的
//        记录分别乘以2,，3,或5的数进行到的位置
        int num2 = 0,num3 = 0, num5=0;
        uglyNumbers[0] = 1;
//        循环按顺序求得丑数
        for (int i=1;i<index;i++){
//            当前位置上的丑数一定是最小的那个
            uglyNumbers[i] = Math.min(uglyNumbers[num2]*2,Math.min(uglyNumbers[num3]*3,uglyNumbers[num5]*5));
//            当前位置的丑数乘以2,3或5已经用过了，移到下一个稍大的丑数位置
            if(uglyNumbers[num2]*2==uglyNumbers[i])
                num2++;
            if(uglyNumbers[num3]*3==uglyNumbers[i])
                num3++;
            if(uglyNumbers[num5]*5==uglyNumbers[i])
                num5++;
        }
        return uglyNumbers[index-1];
    }

    public static void main(String[] args) {
        int i = new GetUglyNumber().GetUglyNumber_Solution(8);
        System.out.println(i);
    }

}
