package com.xl.offer;

import java.util.Stack;

public class MinStack {

    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
     * @param node
     */

//    数据栈和辅助栈
    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int node) {
//        数据栈肯定要压栈
        data.push(node);
//        若该值小于辅助栈栈顶值，即小于当前最小值，则将此数压栈
        if(min.isEmpty()||node<top())
            min.push(node);
        else
//            否则，将栈顶值压栈
            min.push(top());
    }

    public void pop() {
//        弹栈时都要弹出一个
        data.pop();
        min.pop();
    }

    public int top() {
//        返回栈顶值
        return min.peek();
    }

    public int min() {
//        辅助栈栈顶值就是最小值
        return top();
    }

}
