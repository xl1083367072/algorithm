package com.xl.offer;

//二叉树的序列化
public class SerializeBT {

    /**
     * 请实现两个函数，分别用来序列化和反序列化二叉树
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root==null){
//            遇到空节点
            sb.append("#,");
            return sb.toString();
        }
//        遇到非空节点，这里是处理根节点
        sb.append(root.val+",");
//        先序遍历，处理左节点
        sb.append(Serialize(root.left));
//        先序遍历，处理右节点
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    static TreeNode Deserialize(String str) {
        len++;
//        递归结束条件，遍历完了所有节点
        if(len>=str.length())
            return null;
        TreeNode node = null;
        String[] nodes = str.split(",");
//        若是表示空的字符，则跳过，返回的也是null节点
        if(!nodes[len].equals("#")){
//            否则创建该及节点
            node = new TreeNode(Integer.valueOf(nodes[len]));
//            先序遍历，反序列化左节点
            node.left = Deserialize(str);
//            右节点
            node.right = Deserialize(str);
        }
        return node;
    }

    static int len = 0;

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;

        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

}
