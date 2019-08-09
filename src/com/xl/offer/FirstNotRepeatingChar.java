package com.xl.offer;

//第一个只出现一次的字符
public class FirstNotRepeatingChar {

    /**
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
     * 如果没有则返回 -1（需要区分大小写）.
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        int[] charNums = new int[58];
        for (int i=0;i<str.length();i++){
            charNums[((int)str.charAt(i))-65] += 1;
        }
        for (int j=0;j<str.length();j++){
            if(charNums[((int)str.charAt(j))-65]==1)
                return j;

        }
        return -1;
    }

    public static void main(String[] args) {
        int i = new FirstNotRepeatingChar().FirstNotRepeatingChar("abc");
        System.out.println(i);
    }

}
