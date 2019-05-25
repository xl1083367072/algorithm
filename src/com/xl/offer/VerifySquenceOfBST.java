package com.xl.offer;

import java.util.Arrays;

//二叉搜索树的后序遍历序列，考察二叉树
public class VerifySquenceOfBST {

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     * @param sequence
     * @return
     */
//    后序遍历的特点：最后一个节点是根节点，前面分为两部分
//    左半部分元素小于根节点，右半部分大于根节点
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0)
            return false;
        int length = sequence.length;
//        取这颗树的根节点
        int root = sequence[length-1];
        int i = 0;
//        左子树节点都小于根节点
        for (;i<length-1;i++){
            if(sequence[i]>root)
                break;
        }
        int j = i;
//        右子树节点都大于根节点，否则不能构成二叉搜索树的后序遍历序列
        for (;j<length-1;j++){
            if(sequence[j]<root)
                return false;
        }
        boolean left = true;
//        若左子树不为空，验证左子树是否正确
        if(i>0)
            left = VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,i));
        boolean right = true;
//        同样，验证右子树
        if(j<length-1)
            right = VerifySquenceOfBST(Arrays.copyOfRange(sequence,i,j));
        return left&&right;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums,0,2)));
    }

}
