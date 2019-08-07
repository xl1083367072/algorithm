package com.xl.offer;

//整数中1出现的次数
public class NumberOf1Between1AndN {

    /**
     * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
     * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
     * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
     * 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n<=0)
            return 0;
        String str = String.valueOf(n);
        return  numberOf1(str);
    }

    // 比如一个数21345，每次去掉一个最高位，分为1-1345,1346-21345
    // 先计算后一段中1的个数，计算方法是先计算最高位为1的数个数，然后再计算其他位为1的个数
    // 然后计算第一段，递归的方式，再分为1-345,346-1345
    private int numberOf1(String str){
//        求本次递归，最后一个数比如21345,1345的首位数
        int first = Integer.valueOf(str.charAt(0)-'0');
//        看是一个几位的数字
        int length = str.length();
//        如果长度是1且首位是0则结束递归，返回0，即有0个1
        if(length==1&&first==0)
            return 0;
//        如果长度是1且首位是1则结束递归，一位数只有一个1
        if(length==1&&first>0)
            return 1;
        int firstNumDigit = 0;
//        计算最高位为1的数的个数，如果首位是1比如12345，个数就是2345+1
        if(first==1)
            firstNumDigit = Integer.valueOf(str.substring(1))+1;
//        如果首位不是1，则包含了所有最高位为1的数，比如21345，个数就是10的位数-1次方
        else if(first>1)
            firstNumDigit = powerbase10(length-1);
//        其他位为1的个数，1346-21345可以分为1346-11345,11346-21345两段，去掉最高位后是相同的
//        剩下4位数字，固定1位为1，其余为取任意数字，则有2*4*10的3次方种组合
        int otherNumDigit = first*(length-1)*powerbase10(length-2);
//        递归求解
        int recursiveNum = numberOf1(str.substring(1));
        return firstNumDigit+otherNumDigit+recursiveNum;
    }

    private int powerbase10(int n){
        int num = 1;
        for(int i=0;i<n;i++){
            num *= 10;
        }
        return num;
    }

    public static void main(String[] args) {
        int i = new NumberOf1Between1AndN().NumberOf1Between1AndN_Solution(21345);
        System.out.println(i);
    }

}
