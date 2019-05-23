package com.xl.leetcode;

//删除链表倒数第几个节点
public class RemoveNthNodeFromEnd {

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
//        指向头结点的新节点，避免空指针
        ListNode ex = new ListNode(0);
        ex.next = head;
//        两个快慢指针
        ListNode fast = ex;
        ListNode slow = ex;
//        快指针遍历链表，先遍历到n+1的位置
        for (int i=0;i<=n;i++){
            fast = fast.next;
        }
//        然后快慢指针一起遍历，这样当快指针空的时候，慢指针和快指针之间正好相差n个节点的位置
//        也就是要删除节点的上一个节点
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
//        删除掉节点
        slow.next = slow.next.next;
        return ex.next;
    }

    static class ListNode{
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        head = removeNthFromEnd(head, 2);

        for (ListNode node = head;node!=null;node=node.next){
            System.out.println(node.val);
        }
    }

}
