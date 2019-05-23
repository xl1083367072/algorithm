package com.xl.offer;

public class EntryNodeOfLoop {

    /**
     * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead==null){
            return null;
        }
//        取得环中一个节点
        ListNode listNode = meetingNode(pHead);
        if(listNode==null)
            return null;
        int count = 1;
        ListNode curr = listNode;
//        算得环中节点数量
        while (curr.next!=listNode){
            curr = curr.next;
            count++;
        }
        ListNode l1 = pHead;
//        一个快节点先移动节点数量次
        for (int i=0;i<count;i++)
            l1 = l1.next;
        ListNode l2 = pHead;
//        然后快慢节点一起移动，直到相遇，此时节点就是环的入口节点
        while (l1!=l2){
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
    }

//    确定有没有环，如果有，返回环中一个节点
    private ListNode meetingNode(ListNode pHead){
        ListNode slow = pHead.next;
        if(slow==null)
            return null;
        ListNode fast = slow.next;
//        快节点一次移动两下，慢节点一次移动一下，如果相遇，则有环，否则没有环
        while (slow!=null&&fast!=null){
            if(slow==fast)
                return fast;
            slow = slow.next;
            fast = fast.next;
            if(fast!=null)
                fast = fast.next;
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

}
