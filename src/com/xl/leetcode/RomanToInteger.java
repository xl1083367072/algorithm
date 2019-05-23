package com.xl.leetcode;

public class RomanToInteger {

    /**
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * @param
     * @return
     */
    public static int romanToInt(String s) {
//        先取第一个值，因为要从第二个开始遍历
        int result = toNumber(s.charAt(0));
        for (int i = 1;i<s.length();i++){
//            若当前数字大于前面的，则减去前面数的2倍，因为在上一次循环这个数被加了一次
            if(toNumber(s.charAt(i))>toNumber(s.charAt(i-1))){
                result += toNumber(s.charAt(i)) - 2*toNumber(s.charAt(i-1));
            }else {
                result += toNumber(s.charAt(i));
            }
        }
        return result;
    }

    private static int toNumber(char c){
        switch (c){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

}
