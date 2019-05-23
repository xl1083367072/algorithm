package com.xl.offer;

import java.util.ArrayList;
import java.util.Stack;

//逆序打印链表，考察链表
public class PrintLinkedList {

    /**
     * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
     * @param listNode
     * @return
     */
//    递归方法
    ArrayList<Integer> result = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode!=null){
            printListFromTailToHead(listNode.next);
            result.add(listNode.val);
        }
        return result;
    }

//    栈方法
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

}
