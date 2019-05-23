package com.xl.offer;

//注意鲁棒性
public class FindKthToTail {

    /**
     *输入一个链表，输出该链表中倒数第k个结点。
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
//        这两种情况，返回空
        if(head==null||k==0){
            return null;
        }
//        使用双指针
        ListNode result = head;
        ListNode curr = head;
        for (int i=0;i<k-1;i++){
            if(curr.next!=null){
                curr = curr.next;
            }else {
//                若不存在k个节点，则返回空
                return null;
            }
        }
        while (curr.next!=null){
            curr = curr.next;
            result = result.next;
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
