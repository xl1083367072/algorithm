package com.xl.offer;

import java.util.ArrayList;
import java.util.Stack;

//二叉树中和为某一值的路径,用到了栈的特性和二叉树的先序遍历
public class FindPath {

    /**
     *输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     * (注意: 在返回值的list中，数组长度大的数组靠前)
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root==null)
            return result;
//        存放路径节点
        Stack<Integer> path = new Stack<>();
//        记录当前路径和
        int currentSum = 0;
        FindPath(root,target,path,currentSum,result);
        return result;
    }

    private void FindPath(TreeNode root,int target,Stack<Integer> path,int currentSum,ArrayList<ArrayList<Integer>> result){
//        将当前节点加入路径中，计算路径和
        currentSum += root.val;
        path.push(root.val);
//        是否到达了叶子节点
        boolean isLeaf = root.left==null&&root.right==null;
//        若到达了叶子节点，则将路径栈中节点构成路径加入结果集
        if(currentSum==target&&isLeaf){
            ArrayList<Integer> aPath = new ArrayList<>();
            path.forEach( i -> aPath.add(i));
            result.add(aPath);
        }
//        若不是叶子节点
//        继续加入左节点
        if(root.left!=null)
            FindPath(root.left,target,path,currentSum,result);
//        继续加入右节点
        if(root.right!=null)
            FindPath(root.right,target,path,currentSum,result);
//        当要返回到上一级时，即返回到父节点时，将当前节点从路径中删除
        path.pop();
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.forEach( i -> System.out.println(i) );
    }

}
