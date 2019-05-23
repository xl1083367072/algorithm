package com.xl.test;

//欧几里得算法
public class OJLD {

    static int i = 0;

    public static int getMeasure(int a,int b){
        if(b==0)
            return a;
        int c = a%b;
        return getMeasure(b,c);
    }

    public static int getMeasureAndInputNumber(int a,int b){
        i++;
        if(b==0)
            return a;
        int c = a%b;
        System.out.println("第"+i+"此递归,a的值是"+a+",b的值是"+b);
        return  getMeasureAndInputNumber(b,c);
    }

    public static void main(String[] args) {
       /* int measure = OJLD.getMeasure(105, 24);
        System.out.println("两数的最大公约数为"+measure);*/
        int measure = OJLD.getMeasureAndInputNumber(1111111, 1234567);
        System.out.println("两数的最大公约数是"+measure);
    }
}
