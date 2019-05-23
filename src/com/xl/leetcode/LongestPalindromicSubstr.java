package com.xl.leetcode;

public class LongestPalindromicSubstr {

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     *
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     *
     * 输入: "cbbd"
     * 输出: "bb"
     * @param s
     * @return
     */
//    动态规划法
    /*public static String longestPalindrome(String s) {
        if(s==null||s.length()==0){
            return s;
        }
        int length = s.length();
        boolean[][] result = new boolean[length][length];
        int max = 0;
        String str = null;
        for (int i=0;i<length;i++){
            for (int j=0;j<=i;j++){
                result[j][i] = s.charAt(i)==s.charAt(j)&&((i-j)<=2||result[j+1][i-1]);
                if(result[j][i]){
                    int len = i-j+1;
                    if(len>max){
                        max = len;
                        str = s.substring(j,i+1);
                    }
                }
            }
        }
        return str;
    }*/

//    中心扩散法
    public static String longestPalindrome(String s) {
        if(s==null||s.length()==0)
            return s;
//        记录最终回文子串截取范围
        int start = 0;
        int end = 0;
//        以每一个字符为中心，向两边扩散
        for (int i=0;i<s.length();i++){
//            中心点有两种情况，一是类似于aba
            int len1 = getLen(s, i, i);
//            二是类似于abba
            int len2 = getLen(s, i, i + 1);
//            取两种之间更长的
            int len = Math.max(len1,len2);
//            若长度大于当前回文子串长度
            if(len>end-start){
//                分别算出此回文子串开始和结束位置
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
//        左闭右开，所以右边要加1
        return s.substring(start,end+1);
    }

    private static int getLen(String s,int start,int end){
//        第一次循环，start和end是同一个字符或者是相邻的两个字符，若相等，则继续向两边扩散，直到不再相等或超出范围为止
        while (start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
//        返回回文子串长度
        return end-start-1;
    }



    public static void main(String[] args) {
        String s = longestPalindrome("babad");
        System.out.println(s);
    }

}
