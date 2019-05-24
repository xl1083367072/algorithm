package com.xl.offer;

import java.util.Stack;

//栈的压入，弹出序列，考察栈
public class IsPopOrder {

    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，
     * 请判断第二个序列是否可能为该栈的弹出顺序。
     * 假设压入栈的所有数字均不相等。
     * 例如序列1,2,3,4,5是某栈的压入顺序，
     * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
     * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        boolean result = false;
        if(pushA==null||popA==null||pushA.length==0)
            return result;
        Stack<Integer> stack = new Stack<>();
        int i = 0,j = 0;
//        依次测试能否匹配psuhA和popA的元素
        while (j<popA.length){
//            若辅助栈为空，或栈顶值不等于当前需要匹配的元素
            while (stack.isEmpty()||stack.peek()!=popA[j]){
//                依次将pushA中剩下元素压入栈中，直到没有元素或者找到匹配的元素时停止
                if(i==pushA.length)
                    break;
                stack.push(pushA[i]);
                i++;
            }
//            若经过上面压栈操作后，栈顶元素和当前要匹配元素还是不等，则匹配失败
            if(stack.peek()!=popA[j])
                break;
//            否则，将当前匹配的元素弹出，继续匹配下一个元素
            stack.pop();
            j++;
        }
//        匹配完成后，若栈为空且需要匹配的popA数组匹配完成了，则可以有此弹出序列
        if(stack.isEmpty()&&j==popA.length)
            result = true;
        return result;
    }

}
