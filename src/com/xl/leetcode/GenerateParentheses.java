package com.xl.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    /**
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     *
     * 例如，给出 n = 3，生成结果为：
     *
     * [
     *   "((()))",
     *   "(()())",
     *   "(())()",
     *   "()(())",
     *   "()()()"
     * ]
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
//        n是几对括号，即有几个左括号几个右括号
        helpr(result,"",n,n);
        return result;
    }

    public static void helpr(List<String> result,String s,int  left,int right){
//        left代表左括号还剩几个，right括号代表右括号还剩几个
//        如果left>right,即出现(()))的时候，不符合要求，舍弃
        if(left>right)
            return;
//        若左右括号个数都为0了，则符合要求，加入结果集中
        if(left==0&&right==0){
            result.add(s);
            return;
        }
//        若左括号有剩余，向s中加入一个左括号，剩余数量减1
        if(left>0){
            helpr(result,s+"(",left-1,right);
        }
//        若右括号有剩余，向s中加入一个右括号，剩余数量减1
        if(right>0){
            helpr(result,s+")",left,right-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

}
