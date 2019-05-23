package com.xl.offer;

//二进制中1的个数，考察二进制和位运算，与，或，异或，左移，右移
public class NumberOf1 {

    /**
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     * @param n
     * @return
     */
//    移位法，右移一位相当于/2，因为化为二进制后，右移一位，所有数的指数都-1，原来是2³变为2²
//    除法比移位效率低得多,时间复杂度O(n),n是整数的二进制位数
//    将n先和1位与，看最右边第一位是不是1，之后flag左移一位，此时1移到了第二位，再与n位与，看第二位是不是1，所以需要n的二进制位数次循环
    public static int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag!=0){
            if((n&flag)!=0)
                count++;
            flag = flag<<1;
        }
        return count;
    }

//    时间复杂度O(n)，n是有多少个1
//    n和n-1位与的结果是n的最右边的1变为0，所以有多少个1就循环多少次，直到n为0为止
    public static int NumberOf2(int n) {
        int count = 0;
        while (n!=0){
            count++;
            n = (n-1)&n;
        }
        return count;
    }

//    拓展
//    判断一个整数是不是2的整数次方
//    若一个整数是2的整数次方，则二进制中只有1个1
    public static boolean is(int n){
        if((n&(n-1))==0)
            return true;
        return false;
    }

//    给定两个整数m和n，判断m需要改变多少位能得到n
//    m=13,1101需要改变3位才能得到n=10,1010
//    求两个数的异或，不同为1，结果有多少个1就需要改变多少位
    public static int turn(int m,int n){
        int flag = m^n;
        int count = 0;
        while (flag!=0){
            count++;
            flag = (flag-1)&flag;
        }
        return count;
    }


//    举一反三
//    当1个整数减去1之后再与原来的数位与，则原来数最右边的1变为0，其余位不变
    public static void main(String[] args) {
        System.out.println(NumberOf2(9));
        System.out.println(is(9));
        System.out.println(turn(13,10));
    }

}
