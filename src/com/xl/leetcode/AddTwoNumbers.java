package com.xl.leetcode;

public class AddTwoNumbers {

    static class ListNode{

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /*public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        存放计算的两个链表值
        ListNode ln1 = l1,ln2 = l2;
//        存放结果的链表表头
        ListNode result = new ListNode(0);
//        记录存放结果的当前节点
        ListNode current = result;
//        记录每一次计算后进位值，不是0就是1,第一次计算时还没有进位，所以初始化为0
        int carry = 0;
//        两个待计算的链表，只要有一个不为空，就继续计算
        while(ln1!=null||ln2!=null){
            int x = ln1!=null?ln1.val:0;
            int y = ln2!=null?ln2.val:0;
            int sum = x+y+carry;
            carry = sum/10;
            current.next = new ListNode(sum%10);
            current = current.next;
            if(ln1!=null)
                ln1 = ln1.next;
            if(ln2!=null)
                ln2 = ln2.next;
        }
        if(carry>0)
            current.next = new ListNode(carry);
        return result.next;
    }*/

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode ln1 = l1,ln2=l2;
        ListNode result = new ListNode(0);
        ListNode curr = result;
        while (ln1!=null || ln2!=null){
            if(ln1!=null){
                sum += ln1.val;
                ln1 = ln1.next;
            }
            if(ln2!=null){
                sum += ln2.val;
                ln2 = ln2.next;
            }
            curr.next = new ListNode(sum%10);
            sum /= 10;
            curr = curr.next;
        }
        if(sum==1){
            curr.next = new ListNode(1);
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = AddTwoNumbers.addTwoNumbers(l1, l2);
        for (ListNode l=listNode;l!=null;l=l.next){
            System.out.print(l.val+" ");
        }
    }

}


