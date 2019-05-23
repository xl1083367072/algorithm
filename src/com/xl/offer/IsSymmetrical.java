package com.xl.offer;

//对称的二叉树，考察树结构
public class IsSymmetrical {

    /**
     * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot,pRoot);
    }

//    遍历两个相同的树
    private boolean isSymmetrical(TreeNode root1,TreeNode root2){
//        递归结束条件
//        若两树都为空，则是对称的
        if(root1==null&&root2==null)
            return true;
//        若只有一个为空或对应遍历结点的值不等，则不是对称的
        if(root1==null||root2==null)
            return false;
        if(root1.val!=root2.val)
            return false;
//        root1先序遍历，root2遍历顺序是,根右左，反过来的先序遍历
        return isSymmetrical(root1.left,root2.right)&&isSymmetrical(root1.right,root2.left);
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
