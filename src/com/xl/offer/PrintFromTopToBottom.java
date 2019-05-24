package com.xl.offer;

import java.util.ArrayList;
import java.util.LinkedList;

//从上到下打印二叉树，考察队列
public class PrintFromTopToBottom {

    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     * @param root
     * @return
     */
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root==null) {
//            不要返回null，否则会空指针
            return result;
        }
//        双端队列
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
//        从根节点开始，先弹出来队头节点，加入结果集
//        若左节点不为空，则将左加点加入队尾，然后右节点
        while (!deque.isEmpty()){
            TreeNode node = deque.pollFirst();
            result.add(node.val);
            if(node.left!=null)
                deque.addLast(node.left);
            if(node.right!=null)
                deque.addLast(node.right);
        }
        return result;
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
        ArrayList<Integer> list = PrintFromTopToBottom(new TreeNode(0));
        System.out.println(list);
    }

}
