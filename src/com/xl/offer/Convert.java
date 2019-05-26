package com.xl.offer;

//二叉搜索树和双向链表
public class Convert {

    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     * @param pRootOfTree
     * @return
     */
    public static TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null)
            return null;
//        遍历到叶子节点时将叶子节点返回给父节点
        if(pRootOfTree.left==null&&pRootOfTree.right==null)
            return pRootOfTree;
//        构造左子树链表
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode curr = left;
//        定位到左子树链表中的最后一个节点
        while (curr!=null&&curr.right!=null)
            curr = curr.right;
//        将该节点和根节点链接起来
        if(left!=null){
            curr.right = pRootOfTree;
            pRootOfTree.left = curr;
        }
//        构造右子树链表
        TreeNode right = Convert(pRootOfTree.right);
        if(right!=null){
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
//        left是左子树链表的头结点，若不为空，则是整个链表头结点，否则根节点最小，根节点就是头结点
        return left==null?pRootOfTree:left;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right = new TreeNode(14);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        TreeNode node = Convert(root);
    }

}
