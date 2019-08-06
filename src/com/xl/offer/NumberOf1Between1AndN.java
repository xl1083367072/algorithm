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

    private int numberOf1(String str){
        int first = Integer.valueOf(str.charAt(0)-'0');
        int length = str.length();
        if(length==1&&first==0)
            return 0;
        if(length==1&&first>0)
            return 1;
        int firstNumDigit = 0;
        if(first==1)
            firstNumDigit = Integer.valueOf(str.substring(1))+1;
        else if(first>1)
            firstNumDigit = powerbase10(length-1);
        int otherNumDigit = first*(length-1)*powerbase10(length-2);
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
