package com.xl.offer;

//合并两个有序链表，考察链表操作
public class Merge {

    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
//        鲁棒性，一个链表为空，那么合并结果就是另一个链表
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        ListNode result = null;
//        递归构造合并链表
//        若链表1当前节点的值小于链表2当前节点的值
        if(list1.val<list2.val){
//            则当前节点就是小的那个节点
            result = list1;
//            递归构造下一个节点
            result.next = Merge(list1.next,list2);
        }else {
            result = list2;
            result.next = Merge(list1,list2.next);
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
