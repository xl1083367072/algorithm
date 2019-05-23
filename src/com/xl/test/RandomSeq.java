package com.xl.test;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;

//生成n个a,b之间的随机数
public class RandomSeq {

    public static void main(String[] args) throws Exception{
//      生成多少个数
        int number = Integer.parseInt(args[0]);
//      a,b范围之间
        int a = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        Random random = new Random(System.currentTimeMillis());
        FileOutputStream out = new FileOutputStream(args[3]);
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);
        for (int i = 0; i < number; i++) {
//            double random = StdRandom.uniform(a, b);
//            StdOut.printf("%.2f\n",random);
            int randomNum = (int) Math.ceil(a + random.nextDouble() * (b-a));
//            System.out.println(randomNum);
            System.out.println(randomNum);
        }


    }

}
