package com.xl.leetcode;

//合并两个有序链表
public class MergeTwoSortedLists {

    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * 示例：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
//        结果是一个新链表时，保存一个当前节点
        ListNode curr = result;
//        当两个链表对应位置都不为空，即可以比较时
        while (l1!=null&&l2!=null){
//            若l1小，则当前节点值是l1的值，l1继续移动
            if(l1.val<l2.val){
                curr.next = new ListNode(l1.val);
                l1 = l1.next;
            }else {
//                否则l2继续移动
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
//            更新当前节点
            curr = curr.next;
        }
//        若两个链表有一个不为空了，停止上面的循环
//        将还有节点的那个链表剩余部分挂在当前结果的后面
        if(l1!=null){
            curr.next = l1;
        }else {
            curr.next = l2;
        }
        return result.next;
    }

//    递归方法
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
//        有一个链表空了，则返回另一个链表剩余部分
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        if(l1.val<l2.val){
//            若l1值小，则l1当前节点不动，l1移动，递归比较下一个节点的值，依次挂在后面
            l1.next = mergeTwoLists2(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists2(l1,l2.next);
            return l2;
        }
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode listNode = mergeTwoLists2(l1, l2);
        for (ListNode node=listNode;node!=null;node=node.next){
            System.out.println(node.val);
        }
    }

}
