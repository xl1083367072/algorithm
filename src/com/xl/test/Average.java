package com.xl.test;

import java.util.Scanner;

public class Average {

    public static void main(String[] args) {
        double sum = 0;
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        while(!scanner.hasNext("c")){       //输入c时结束输入
            sum += scanner.nextDouble();
            i++;
        }
        System.out.printf("%.2f\n",sum/i);
    }
}
