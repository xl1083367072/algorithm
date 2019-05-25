package com.xl.offer;

//复杂链表的复制，分解复杂问题
public class LinkedListClone {

    /**
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
     * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead==null)
            return null;
//        分解处理
        copyNode(pHead);
        connectRandomNode(pHead);
        return splitListNode(pHead);
    }

//    第一步，将每一个复制节点链接在原节点之后
    private void copyNode(RandomListNode pHead){
        RandomListNode curr = pHead;
        while (curr!=null){
//            创建一个复制节点
            RandomListNode copyNode = new RandomListNode(0);
            copyNode.label = curr.label;
//            复制节点之后链接下一个原节点
            copyNode.next = curr.next;
            copyNode.random = null;
//            链接在原节点之后
            curr.next = copyNode;
            curr = copyNode.next;
        }
    }

//    第二步，链接复制节点的任意节点
    private void connectRandomNode(RandomListNode pHead){
        RandomListNode curr = pHead;
        while (curr!=null){
//            取原节点的复制节点
            RandomListNode copyNode = curr.next;
            if(curr.random!=null){
//                这个复制节点的任意节点就是原节点的任意节点的下一个节点
                copyNode.random = curr.random.next;
            }
            curr = copyNode.next;
        }
    }

//    第三步，分解成两个链表，一个原链表，一个复制链表
    private RandomListNode splitListNode(RandomListNode pHead){
        RandomListNode curr = pHead;
//        复制链表偷节点
        RandomListNode cloneHead = null;
//        当前复制节点
        RandomListNode cloneNode = null;
        if(curr!=null){
//            先找到复制链表的头结点
            cloneNode = curr.next;
            cloneHead = cloneNode;
            curr.next = cloneNode.next;
            curr = curr.next;
        }
        while (curr!=null){
//            复制链表链接下一个复制节点
            cloneNode.next = curr.next;
            cloneNode = cloneNode.next;
//            原链表链接下一个原节点
            curr.next = cloneNode.next;
            curr = curr.next;
        }
        return cloneHead;
    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;
        RandomListNode(int label) {
            this.label = label;
        }
    }

}
