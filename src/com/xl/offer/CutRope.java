package com.xl.offer;

//剪绳子，考察动态规划和贪婪算法
public class CutRope {

    /**
     * 给定绳子长度，判断绳子怎么剪可以使各段长度乘积最大
     * @param length
     * @return
     */
//    动态规划,O(n²)
//    适合用动态规划的情形
//    求最优解，比如求最大值，最小值等
//    整个问题最优解依赖子问题的最优解
//    小问题重复出现
//    从上往下分析问题，从下往上求解问题
    public static int cutRope(int length){
//        1,2,3长度时直接返回结果
        if(length<2)
            return 0;
        if(length==2)
            return 1;
        if(length==3)
            return 2;
//        存放f(n)的值，即长度为n时最大乘积，也就是最优解
        int[] products = new int[length+1];
//        初始值，自底向上法计算每一步的最优解
//        products[3]=3,就代表长度为3的绳子的长度
//        比如绳子长度为4时，分解为1,3两段，products[1]*products[3]此时长度为3
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max = 0;
//        从长度为4开始，自底向上计算每一步的最优解，即最大乘积
        for (int i=4;i<=length;i++){
            max = 0;
//            从1到绳子长度的一半，循环计算长度乘积，算得最大乘积
//            比如长度为4时，分别计算1*3,2*2得2*2更大，4就作为绳子长度为4的最优解
//            每一个绳子长度都可以分解为两个最优解的乘积，比如长度为9时，分解为3*6,6分解为3*3，最终，3*3*3就是9的最优解
            for (int j=1;j<=i/2;j++){
                int product = products[i-j] * products[j];
                if(product>max){
                    max = product;
                    products[i] = max;
                }
            }
        }
        return max;
    }

//    贪婪算法
//    每一步都选最优解，并且这些最优解可以构成这个问题的最优解则可以使用贪心算法
//    所以最重要的是要用数学证明每一步的最优解最终也是这个问题的最优解
    public static int cutRope2(int length){
        if(length<2)
            return 0;
        if(length==2)
            return 1;
        if(length==3)
            return 2;
//        长度大于5时,尽量每一段分为长度为3
        int timesOf3 = length/3;
        if(length-3*timesOf3==1)
            timesOf3 -= 1;
//        长度小于5时,若最后可以剩出长度为4的段,则把这个长度为4的分成2段长度为2的
        int timesOf2 = (length - 3*timesOf3)/2;
//        最终结果就是timesOf3个3相乘,timesOf2个2相乘
        return (int) (Math.pow(3,timesOf3)*Math.pow(2,timesOf2));
    }

    public static void main(String[] args) {
        System.out.println(cutRope(10));
    }

}
