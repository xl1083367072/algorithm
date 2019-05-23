package com.xl.leetcode;

//两两交换链表中的节点
public class SwapNodesInPairs {

    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     *
     *
     * 示例:
     *
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode l1 = result;
        ListNode l2 = head;
        while (l2!=null&&l2.next!=null){
            ListNode curr = l2.next.next;
            l1.next = l2.next;
            l2.next.next = l2;
            l2.next = curr;
            l1 = l2;
            l2 = l2.next;
        }
        return result.next;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        ListNode listNode = swapPairs(l1);
        for (ListNode node=listNode;node!=null;node=node.next)
            System.out.println(node.val);
    }

}
