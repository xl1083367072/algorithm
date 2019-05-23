package com.xl.leetcode;

import java.util.Stack;

//判定有效括号
public class ValidParentheses {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if(s==null||s.length()==0){
            return true;
        }
//        这种匹配类型的用栈
        Stack<Character> stack = new Stack<>();
        for (Character ch:s.toCharArray()){
//            对于每一个左括号，都压入一个后面应该存在的与之匹配的右括号
            if(ch=='('){
                stack.push(')');
            }else if(ch=='['){
                stack.push(']');
            }else if(ch=='{'){
                stack.push('}');
            }else {
//                若栈空，而字符串还没结束，说明缺少域有括号匹配的左括号
//                若相邻的弹出的括号与右括号不批判而，则整合字符串不匹配
                if(stack.isEmpty()||stack.pop()!=ch){
                    return false;
                }
            }
        }
//        若最后栈内为空，则全部匹配成功，返回true，否则返回false
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{{[()]}}"));
    }

}
