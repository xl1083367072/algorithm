package com.xl.offer;

//用两个栈实现队列，考察栈和队列
import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class TwoStackImplQueue {

    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

//    在队列尾部添加节点
    public static void push(int node) {
//        入队都转化为stack1的压栈操作
//        也就是所有新增节点都放入stack1中
        stack1.push(node);
    }

//    在队列头部删除节点
    public static int pop() {
//        每当出队时，查看stack2是否为空，若为空，就把stack1中的结点依次弹出压入stack2中，这样顺序就和入队时一致了
//        因为删除节点都是删除的stack2中的节点，也就是stack2弹栈
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()) {
                Integer node = stack1.pop();
                stack2.push(node);
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        System.out.println(pop());      //1
        System.out.println(pop());      //2
        push(4);
        push(5);
        System.out.println(pop());      //3
    }

}
