package com.xl.offer;

//斐波那契数列，考察递归和循环
public class Fibonacci {

    /**
     * 斐波那契数列：
     * f(n)=0 n=0
     * f(n)=1 n=1
     * f(n)=f(n-1)+f(n-2) n>1
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
     * n<=39
     * @param n
     * @return
     */
//    递归解法
    public static int Fibonacci(int n) {
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

//    自下而上法,目标项等于前两项之和
//    由f(0)+f(1)=f(2),f(1)+f(2)=f(3),f(0)和f(1)已知，可以算出f(2),f(1)和f(2)已知可以算出f(3)
//    所以每项只要算一次就行了，时间复杂度为O(n)
    public static int Fibonacci2(int n) {
        int[] arr = {0,1};
        if(n<2){
            return arr[n];
        }
        int one = 0;
        int two = 1;
        int result = 0;
        for (int i=2;i<=n;i++){
            result = one + two;
            one = two;
            two = result;
        }
        return result;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(Fibonacci2(50));
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

}
