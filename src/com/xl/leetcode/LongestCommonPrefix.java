package com.xl.leetcode;

public class LongestCommonPrefix {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     *
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     *
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     *
     * 所有输入只包含小写字母 a-z 。
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs==null|| strs.length==0)
            return "";
//        除了第一个单词外的其他单词，与第一个单词从第一个字符依次比较，直到有一个不等或者有一个单词字符耗尽为止
        for (int i = 0;i<strs[0].length();i++){
            char c = strs[0].charAt(i);
            for (int j = 1;j < strs.length;j++){
                if(strs[j].length()<=i||strs[j].charAt(i)!=c)
                    return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

}
