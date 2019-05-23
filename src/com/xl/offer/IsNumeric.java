package com.xl.offer;

public class IsNumeric {

    /**
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
     * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     * @param str
     * @return
     */

    static int index = 0;

//    注意数组越界
    public static boolean isNumeric(char[] str) {
        if(str==null||str.length==0)
            return false;
//        先判断是否有整数部分，用有符号整数判断
        boolean result = isNum(str);
//        接着看是否是小数点
        if(index!=str.length&&str[index]=='.'){
            index++;
//            若是，判断是否是无符号整数，因为小数部分不能有正负号
//            之所以加上||,因为.123和123.也符合，只要有一个为true就符合
            result = isUnsignedNum(str)||result;
        }
//        接着判断是否有指数部分
        if(index!=str.length&&(str[index]=='E'||str[index]=='e')){
            index++;
//            指数部分可以有符号，也可以没有
//            之所以加上&&，是因为指数部分，前后都要有数字
            result = result&&isNum(str);
        }
//        返回结果并判断当前字符数组是否判断结束
        return result&&index==str.length;
    }

//    判断是否符合无符号整数
    private static boolean isUnsignedNum(char[] str){
        int count = 0;
        while (index!=str.length&&str[index]>='0'&&str[index]<='9'){
            index++;
            count++;
        }
        return count>0;
    }

//    判断是否符合有符号整数
    private static boolean isNum(char[] str){
        if(index!=str.length&&(str[index]=='+'||str[index]=='-'))
            index++;
        return isUnsignedNum(str);
    }

    public static void main(String[] args) {
        char[] str = {'1','2','e'};
        System.out.println(isNumeric(str));
    }

}
