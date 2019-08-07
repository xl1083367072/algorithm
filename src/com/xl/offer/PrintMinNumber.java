package com.xl.offer;

import java.util.ArrayList;
import java.util.Collections;

//把数组排成最小的数
public class PrintMinNumber {

    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
     * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
     * 则打印出这三个数字能排成的最小数字为321323。
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int [] numbers) {
        String result = "";
//        将多个整数放入集合中
        ArrayList<Integer> list = new ArrayList<>();
        for (int a:numbers){
            list.add(a);
        }
//        将此集合排序，按照字符串的默认规则排序
        Collections.sort(list,(num1, num2) -> {
//            转换成字符串进行比较，多个整数组合在一起会产生大数问题，可能溢出，可以用字符串比较
            String s1 = num1+""+num2;
            String s2 = num2+""+num1;
            return s1.compareTo(s2);
        });
//        拼接字符串
        for (Integer num:list){
            result += num;
        }
        return result;
    }

    public static void main(String[] args) {
        new PrintMinNumber().PrintMinNumber(new int[]{3,32,321});
    }

}
