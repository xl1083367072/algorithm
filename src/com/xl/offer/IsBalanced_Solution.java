package com.xl.offer;

//平衡二叉树
public class IsBalanced_Solution {

//    输入一棵二叉树，判断该二叉树是否是平衡二叉树。
    public boolean IsBalanced_Solution(TreeNode root) {
        int i = IsBalanced_Solution2(root);
        if(i==-1)
            return false;
        return true;
    }

    private int IsBalanced_Solution2(TreeNode root) {
        if(root==null)
            return 0;
        int left = IsBalanced_Solution2(root.left);
        if(left==-1)
            return -1;
        int right = IsBalanced_Solution2(root.right);
        if(right==-1)
            return -1;
        return Math.abs(left-right)>1?-1:Math.max(left,right)+1;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;

        }
    }

}
