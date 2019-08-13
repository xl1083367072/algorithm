package com.xl.offer;

//两个链表的第一个公共结点
public class BindingAwareModelMap {

    //输入两个链表，找出它们的第一个公共结点。
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = getLength(pHead1);
        int len2 = getLength(pHead2);
        if(len1>len2){
            for (int i=0;i<len1-len2;i++){
                pHead1 = pHead1.next;
            }
        }else {
            for (int i=0;i<len2-len1;i++){
                pHead2 = pHead2.next;
            }
        }
        while (pHead1!=null&&pHead2!=null&&pHead1!=pHead2){
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }

    private int getLength(ListNode node){
        int len = 0;
        while (node!=null){
            node = node.next;
            len++;
        }
        return len;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        new BindingAwareModelMap().FindFirstCommonNode(node,node);
    }

}
