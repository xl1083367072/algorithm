package com.xl.offer;

//二叉树的镜像，考察二叉树
public class Mirror {

    /**
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     * 输入描述:
     * 二叉树的镜像定义：源二叉树
     *     	    8
     *     	   /  \
     *     	  6   10
     *     	 / \  / \
     *     	5  7 9 11
     *     	镜像二叉树
     *     	    8
     *     	   /  \
     *     	  10   6
     *     	 / \  / \
     *     	11 9 7  5
     * @param root
     */
//    从根节点开始，将所有非叶节点的左右子节点都交换位置
    public void Mirror(TreeNode root) {
//        空树处理
        if(root==null)
            return;
//        若左树和右树都空了，则停止递归
        if(root.left==null&&root.right==null)
            return;
//        交换左右节点，左或右节点可能有一个为空，不影响交换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
//        若左子树不空，继续交换左子树的左右节点
        if(root.left!=null)
            Mirror(root.left);
        if(root.right!=null)
            Mirror(root.right);
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
