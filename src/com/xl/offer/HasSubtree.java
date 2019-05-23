package com.xl.offer;

//树的子结构，考察二叉树
public class HasSubtree {

    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
//        递归找出root1中和root2根相同的节点
        if(root1!=null&&root2!=null){
//            若找到根节点，则去判断是否含有此子树
            if(root1.val==root2.val)
                result = hasTree(root1,root2);
//            否则就继续递归寻找根节点
            if(!result)
                result = HasSubtree(root1.left,root2);
            if(!result)
                result = HasSubtree(root1.right,root2);
        }
        return result;
    }

//    判断是否含有子树
    private boolean hasTree(TreeNode root1,TreeNode root2){
//        当root2没有节点时，递归结束，子树节点验证完毕
        if(root2==null)
            return true;
//        若root1先为空，则没有此子树
        if(root1==null)
            return false;
//        若对应两个节点值不等，则没有此子树
        if(root1.val!=root2.val)
            return false;
//        递归判断，必须左右各节点都对应相等，才含有此子树
        return hasTree(root1.left,root2.left)&&hasTree(root1.right,root2.right);
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
