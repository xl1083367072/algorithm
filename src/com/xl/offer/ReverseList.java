package com.xl.offer;

//反转链表，考察链表
public class ReverseList {

    /**
     * 输入一个链表，反转链表后，输出新链表的表头。
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
//        反转后的表头
        ListNode result = null;
//        当前节点
        ListNode curr = head;
//        前一个节点
        ListNode prev = null;
        while (curr!=null){
//            下一个节点，正好保存了截断后的下一个节点
            ListNode next = curr.next;
//            若没有下一个节点了，则当前节点就是最后一个节点，也就是反转后的表头
            if(next==null)
                result = curr;
//            当前节点改为指向前一个节点，这样下一个节点也就不指向前一个节点了，还是单向
            curr.next = prev;
//            当前节点变为前一个节点
            prev = curr;
//            下一个节点变为当前节点，
            curr = next;
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
