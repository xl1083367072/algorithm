package com.xl.search;

import edu.princeton.cs.algs4.Queue;

//红黑二叉查找树
public class RedBlackBST<Key extends Comparable<Key>,Value> {

    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node{
        private Key key;
        private Value val;
        private Node left,right;
        private int N;
        private boolean color;

        public Node(Key key, Value val, int n, boolean color) {
            this.key = key;
            this.val = val;
            N = n;
            this.color = color;
        }
    }

    private boolean isRed(Node node){
        if(node==null)
            return false;
        return node.color == RED;
    }

//    左旋该节点右链接,h是根节点,x是根节点右链接
//    左旋就是将大的节点和小的节点调换位置
    private Node rotateLeft(Node h){
//        先把根节点右链接取出来,下面要被覆盖掉
        Node x = h.right;
//          根节点右链接的左链接是介于根节点和当前节点右链接之间的,将它给根节点右链接,取代了右链接的位置
        h.right = x.left;
//        然后,将根节点给原来右链接的左连接
        x.left = h;
//        将原来根节点颜色给原来根节点右链接,原来根节点颜色是不确定的,原来根节点原来右链接是红色的
        x.color = h.color;
//        将原来根节点颜色变红,其实就是交换颜色
        h.color = RED;
//        交换树中节点数量
        x.N = h.N;
//        由于原来根节点更换了右链接,所以重新计算大小
        h.N = 1+size(h.left)+size(h.right);
//        返回现在根节点给原来根节点的父节点,也就是x取代h的位置
        return x;
    }

//    右旋
//    当节点是2-3树中的3节点时是红色
    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1+size(h.left)+size(h.right);
        return x;
    }

//    变色,当节点左右链接都是红色,此时相当于2-3树中的4节点,需要做调整,即把中间节点上移
//    此时原来的左右链接就变成类2-3树中的普通链接,就变黑了,将节点向上传递,如果还是4节点继续分解,即将红链接向上传递,直到遇到一个非红链接为止
    private void flipColors(Node node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    public int size(){
        return size(root);
    }

    private int size(Node node){
        if(node==null)
            return 0;
        return node.N;
    }

    public void put(Key key,Value val){
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node node,Key key,Value val){
//        若不存在该键,则新建且是红色
        if(node==null)
            return new Node(key,val,1, RED);
        int cmp = key.compareTo(node.key);
        if(cmp<0)
            node.left =  put(node.left,key,val);
        else if(cmp>0)
            node.right = put(node.right,key,val);
        else
            node.val = val;
//        插入或更新完,调整树结构,这里是有先后顺序的
//        若右链接为红左连接不为红,则左旋
        if(isRed(node.right)&&!isRed(node.left))
            node = rotateLeft(node);
//        若连续两个左连接为红,则右旋
        if(isRed(node.left)&&isRed(node.left.left))
            node = rotateRight(node);
//        若左链接为红右链接也为红,则变色
        if(isRed(node.left)&&isRed(node.right))
            flipColors(node);
        node.N = size(node.left)+size(node.right)+1;
        return node;
    }

    public Value get(Key key){
        return get(root,key);
    }

    private Value get(Node node,Key key){
        if(node==null)
            return null;
        int cmp = key.compareTo(node.key);
        if(cmp<0)
            return get(node.left,key);
        else if(cmp>0)
            return get(node.right,key);
        else
            return node.val;
    }

    public boolean contains(Key key){
        return get(key)!=null;
    }

    public Iterable<Key> keys(){
        return keys(min(),max());
    }

    //    查找指定范围内的key集合
    public Iterable<Key> keys(Key lo,Key hi){
        Queue<Key> queue = new Queue<>();
        keys(root,queue,lo,hi);
        return queue;
    }

    //    中序遍历
    public void keys(Node node, Queue<Key> queue, Key lo, Key hi){
//        若树空,则结束递归
        if(node==null)
            return;
//        当前节点分别和最小键最大键比较
        int cmp1 = lo.compareTo(node.key);
        int cmp2 = hi.compareTo(node.key);
//        若最小键小于当前节点，一直查找左子树直到树空               --左
        if(cmp1<0)
            keys(node.left,queue,lo,hi);
//        多当前节点在查找范围内,则入队                            --根
        if(cmp1<=0&&cmp2>=0)
            queue.enqueue(node.key);
//        若最大键大于当前节点,一直查找右子树直到树空                --右
        if(cmp2>0)
            keys(node.right,queue,lo,hi);
    }

    public Key min(){
        return min(root).key;
    }

    private Node min(Node node){
        if(node.left==null)
            return node;
        return min(node.left);
    }

    public Key max(){
        return max(root).key;
    }

    private Node max(Node node){
        if(node.right==null)
            return node;
        return max(node.right);
    }


}
