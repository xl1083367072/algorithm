package com.xl.offer;

//二叉树的下一个节点，考察二叉树的遍历
public class GetNext {

    /**
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     * @param pNode
     * @return
     */
//    分三种情形
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
//       如果为空，直接返回空
        if(pNode==null)
            return null;
//        存放最终结果
        TreeLinkNode result = null;
//        一是，目标节点右子树不为空
        if(pNode.right!=null) {
//            则取右节点
            TreeLinkNode right = pNode.right;
//            一直遍历左节点，直到最后一个左节点
            while (right.left != null) {
                right = right.left;
            }
            result = right;
//            二是，右子树为空时且父节点不为空
        }else if(pNode.next!=null){
            TreeLinkNode parent = pNode.next;
            TreeLinkNode current = pNode;
//           当父节点不为空，且当前节点是父节点的右节点时，一直循环
//            有两种情况，一是最终父节点为空了，则返回的是空，代表这是最后一个节点，没有下一个节点
//            二是最终找到了一个节点，是它父节点的左节点，则这就是下一个节点
            while (parent!=null&&current==parent.right){
                current = parent;
                parent = parent.next;
            }
            result = parent;
        }
//        三是上面条件都不满足，则返回的是空，即目标节点就是最后一个节点，没有下一个节点
        return result;
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }


}
