package com.xl.offer;

//重建二叉树，考察二叉树的遍历
public class ReConstructBinaryTree {

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     * @param pre
     * @param in
     * @return
     */
    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
//        递归思想
//        整棵树的节点
        TreeNode root = reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }

    private static TreeNode reConstructBinaryTree(int [] pre,int preLeft,int preRight,int [] in,int inLeft,int inRight) {
//        左指针超过右指针时停止递归
        if(preLeft>preRight||inLeft>inRight)
            return null;
//        先序遍历pre的当前最左边位置就是这个子树的树根
        TreeNode node = new TreeNode(pre[preLeft]);
//        去中序遍历中查找这个根节点
        for (int i=inLeft;i<=inRight;i++){
//            找到了根节点时
            if(in[i]==pre[preLeft]){
//                继续构造左子树
//                中序遍历中根节点所在位置之前的节点就是左子树中的所有节点
//                最左端inleft就是本次循环的最左端位置，最右端就是根节点的前一个节点
                node.left = reConstructBinaryTree(pre,preLeft+1,preLeft+i-inLeft,in,inLeft,i-1);
//                继续构造右子树
//                中序遍历中根节点所在位置之后的节点就是右子树中的所有节点
//                最左端就是根节点的后一个节点，最右端就是此次循环最右端位置
                node.right = reConstructBinaryTree(pre,i-inLeft+preLeft+1,preRight,in,i+1,inRight);
                break;
            }
        }
        return node;
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode root = reConstructBinaryTree(pre, in);
    }

}
