package com.xl.mylib;

import java.util.Random;

//取随机数
public class StdRandom {

//    种子数
    private static long seed;

    private static Random random;

//    用当前时间作为种子数创建一个random对象
    static{
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }

//  返回a,b之间的一个随机实数
    public static double uniform(double a,double b){
        if(!(a<b))
            throw new IllegalArgumentException("输入有误");
        return a+random.nextDouble()*(b-a);
    }
}
