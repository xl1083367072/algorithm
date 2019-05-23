package com.xl.offer;

//数值的整数次方，考察程序的正确性和鲁棒性
public class Power {

    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * @param base
     * @param exponent
     * @return
     */
    public double power(double base, int exponent){
//        底数为0，指数是负数的错误情况
        if(base==0.0&&exponent<0){
            throw new RuntimeException("底数为0时，指数不能为负数");
        }
//        指数小于0时
        if(exponent<0)
            return 1.0/powerWithExponent(base,-exponent);
        else
            return powerWithExponent(base,exponent);
    }

//   指数大于0，底数大于0时正常
//   指数等于0，底数大于0时，直接返回result初值为1
//   指数大于0，底数等于0时，返回的是0
//   指数等于0，底数等于0时没有意义，这里返回的是1
    private double powerWithExponent(double base,int exponent){
        double result = 1.0;
        for (int i=0;i<exponent;i++){
            result *= base;
        }
        return result;
    }

}
