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
        TreeNode last = new TreeNode(0);
        convert(pRootOfTree,last);
        TreeNode first = last;
        while (first!=null&&first.left!=null){
            first = first.left;
        }
        return first;
    }

    private static void convert(TreeNode root,TreeNode last){
        if(root==null)
            return;
        TreeNode curr = root;
        if(curr.left!=null)
            convert(curr.left,last);
        curr.left = last;
        if(last!=null)
            last.right = curr;
        last = curr;
        if(curr.right!=null)
            convert(curr.right,last);
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
