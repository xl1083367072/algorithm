package com.xl.leetcode;

import java.util.PriorityQueue;

public class MergeKSortLists {

    /**
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     *
     * 示例:
     *
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     */
//    优先队列法
//    思想：因为都是有序链表，所以将头节点用优先队列保存，那么这些头结点就变得有序了
//    在优先队列中，从小到大顺序存放，然后每次弹出来一个队头节点，也就是当前优先队列中的最小节点
//    之后，把它所在链表次小节点继续放入优先队列，那么它也会以合适的顺序弹出，如此往复，
//    就每次弹出来的都是当前最小值
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0)
            return null;
//        指定比较器，对ListNode排序
//        因为都是有序节点，所以，将每个链表头结点放入优先队列后，各个链表就会因头节点变得有序
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,(o1, o2) -> o1.val-o2.val);
        ListNode result = new ListNode(0);
        ListNode curr = result;
//        将每个链表头结点放入优先队列，此时第一个节点是有序地
        for (ListNode listNode:lists){
            queue.add(listNode);
        }
//        当优先队列中还有节点时，继续排序
        while (!queue.isEmpty()){
//            弹出当前队列中最小值，也就是队头
            ListNode listNode = queue.poll();
//            将该节点加入结果链表
            curr.next = listNode;
//            当前指针移动到这个最小值节点
            curr = curr.next;
//            若它还有后续节点，即次小节点，这个次小只是对于这个链表而言
            if(curr.next!=null){
//                那么就把次小节点加入优先队列，放到合适位置，那么这个节点在优先队列中也就是有序的了
                queue.add(curr.next);
            }
        }
        return result.next;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);
        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);
        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);
        ListNode listNode = mergeKLists(new ListNode[]{listNode1, listNode2, listNode3});
        for (ListNode node = listNode;node!=null;node=node.next){
            System.out.println(node.val);
        }
    }

}
