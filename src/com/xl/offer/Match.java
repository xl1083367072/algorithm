package com.xl.offer;

public class Match {

    /**
     * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
     * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
     * 在本题中，匹配是指字符串的所有字符匹配整个模式。
     * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
     * @param str
     * @param pattern
     * @return
     */
    public static boolean match(char[] str, char[] pattern) {
        if(str==null||pattern==null)
            return false;
        int sIndex = 0;
        int pIndex = 0;
        return matchCore(str,sIndex,pattern,pIndex);
    }

//    重点要注意数组越界问题
    private static boolean matchCore(char[] str, int sIndex,char[] pattern,int pIndex) {
//        当目标串和模式串同时结束，则匹配成功
        if(sIndex == str.length && pIndex == pattern.length)
            return true;
//        若模式串结束了，而目标串还没结束，则匹配失败
        if(sIndex != str.length && pIndex == pattern.length)
            return false;
//        模式串数组有下一个字符，且下一个字符是*时，说明可以匹配0到n个该字符，分几种情况
        if(pIndex+1<pattern.length&&pattern[pIndex+1]=='*'){
//            若目标串没有结束且目标串和模式串当前位置字符匹配时，或者模式串当前字符是.且目标串没有结束时
            if((sIndex!=str.length&&str[sIndex]==pattern[pIndex])||(pattern[pIndex]=='.'&&sIndex!=str.length)){
//                可以分三种情况匹配，任意一种匹配成功就认为可以匹配
//                第一种是，*匹配1个该字符，匹配后，目标串后移一位，模式串跳过*
                return matchCore(str,sIndex+1,pattern,pIndex+2)
//                        第二种情况是，一直匹配该字符，目标串后移一位，模式串状态不变，可以继续匹配该字符
                        ||matchCore(str,sIndex+1,pattern,pIndex)
//                        第三种情况是，匹配0个该字符，目标串不变，模式串跳过*
                        ||matchCore(str,sIndex,pattern,pIndex+2);
            }else {
//                若当前字符不匹配，那就跳过*，也就是匹配0个，还有目标串结束了，模式串还没结束
                return matchCore(str,sIndex,pattern,pIndex+2);
            }
        }
//        若下一个字符不是*，则匹配当前字符
        if((sIndex!=str.length&&str[sIndex]==pattern[pIndex])||(pattern[pIndex]=='.'&&sIndex!=str.length)){
            return matchCore(str,sIndex+1,pattern,pIndex+1);
        }
//        否则，就匹配失败
        return false;
    }

    public static void main(String[] args) {
        char[] str = new char[0];
        char[] pattern = {'.','*'};
        System.out.println(match(str,pattern));
    }

}
