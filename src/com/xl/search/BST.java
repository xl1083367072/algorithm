package com.xl.search;

import edu.princeton.cs.algs4.Queue;

//二叉查找树
public class BST<Key extends Comparable<Key>,Value> {

    private Node root;

    private class Node{
        private Key key;
        private Value val;
        private Node left;
        private Node right;
//        节点计数器,以该节点为根的树中节点个数,空节点定义为0,每个节点N=size(this.left)+size(this.right)+unit1
        private int N;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            N = n;
        }
    }

    public int size(){
        return size(root);
    }

    private int size(Node node){
        if(node==null)
            return 0;
        else
            return node.N;
    }

    public Value get(Key key){
        return get(root,key);
    }

//    查找指定根节点查找,逐级向上返回查找到的值
    private Value get(Node node,Key key){
        if(node==null)
            return null;
        int cmp = key.compareTo(node.key);
//        若查找的键小于当前节点键则去该节点左子树中查找,若大于则去右子树中查找,否则逐级向上返回结果
        if(cmp<0)
            return get(node.left,key);
        else if(cmp>0)
            return get(node.right,key);
        else
            return node.val;
    }

    public void put(Key key,Value val){
        root = put(root,key,val);
    }

//    插入,逐级向上返回当前节点引用,只在底部插入新节点或修改节点的值,所以不会破坏树的结构,而且保证有序性
    public Node put(Node node,Key key,Value val){
//        若树空了,则新建节点返回给父节点
        if(node==null)
            return new Node(key,val,1);
        int cmp = key.compareTo(node.key);
//        若小于则去左子树查找,将当前节点返回给父节点左孩子
        if(cmp<0)
            node.left = put(node.left,key,val);
        else if(cmp>0)
//            若大于则去右子树中查找,将当前节点返回给父节点右孩子
            node.right = put(node.right,key,val);
//        若等于则修改值
        else
            node.val = val;
//        将路径上每个节点N修改
        node.N = size(node.left)+size(node.right)+1;
//        每此递归返回当前节点引用
        return node;
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
    public void keys(Node node, Queue<Key> queue,Key lo,Key hi){
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

    public boolean contains(Key key){
        return get(key)!=null;
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

//    删除会使树发生改变
//    从根节点开始,一直查找左子树,直到当前节点左子树为空,则把当前节点右子树返回
    public Node deleteMin(Node node){
        if(node.left==null)
            return node.right;
//        若发生删除,则会把当前节点右子树引用给父节点左子树,这样当前节点就没有引用了,会被垃圾回收
        node.left = deleteMin(node.left);
//        修改路径上每一个节点N
        node.N = size(node.left)+size(node.right)+1;
//        没有发生删除的节点,把此节点正常返回给原先的父节点,没有发生变化
        return node;
    }

    public void deleteMax(){
        root = deleteMax(root);
    }

//    删除指定节点子树的最大键
    public Node deleteMax(Node node){
        if(node.right==null)
            return node.left;
        node.right = deleteMax(node.right);
        node.N = size(node.left)+size(node.right)+1;
        return node;
    }

    public void delete(Key key){
        root = delete(root,key);
    }

//    删除指定键
    public Node delete(Node node,Key key){
        if(node==null)
            return null;
//        先查找该键
        int cmp = key.compareTo(node.key);
        if(cmp<0)
            node.left = delete(node.left,key);
        else if(cmp>0)
            node.right = delete(node.right,key);
//        若查找到了该键,要调整该节点左右子树位置
        else{
//            若该键左子树或右子树为空,那么只有一颗子树需要调整,则直接把该左或右子树返回给该节点父节点的左或右子树
            if(node.left==null)
                return node.right;
            if(node.right==null)
                return node.left;
//            若左右子树都存在,先保存要删除节点的引用
            Node t = node;
//            去右子树中查找最小键,因为要找一个合适的键替代该键位置,找右子树中最小键或左子树中最大键,这样替代后,依然有序
//            并将合适的键放在被删除键的位置
            node = min(node.right);
//            从被删除节点右子树中查找上面那个已经替代了被删除键位置的键,并逐渐返回修改路径节点引用,deleteMin后依然有序
            node.right = deleteMin(t.right);
//            将被删除节点左子树给替代它的节点的左子树
            node.left = t.left;
        }
//        修改路径上每个节点N
        node.N = size(node.left)+size(node.right)+1;
//        没有发生变化的节点依然返回给原来父节点
        return node;
    }

    public Key floor(Key key){
        Node node = floor(root,key);
        if(node==null)
            return null;
        return node.key;
    }

//    这里递归返回的是目标结点,即小于该节点的最大节点
    private Node floor(Node node,Key key){
        if(node==null)
            return null;
        int cmp = key.compareTo(node.key);
//        若有相等的即为目标节点
        if(cmp==0)
            return node;
//        若指定节点小于当前节点,则一直去左子树查找,直到有相等或大于当前节点的才有可能是目标结点
        if(cmp<0)
            return floor(node.left,key);
//        若指定节点大于当前节点,则去右子树中查找,看有没有比指定节点小的节点
        Node f = floor(node.right, key);
//        如果有,那该节点就是目标结点,就是
        if(f!=null)
            return f;
//        否则该子树的根节点就是小于指定节点的最大节点了
        else
            return node;
    }

    public Key ceil(Key key){
        Node node = ceil(root, key);
        if(node==null)
            return null;
        return node.key;
    }

    public Node ceil(Node node,Key key){
        if(node==null)
            return null;
        int cmp = key.compareTo(node.key);
        if(cmp==0)
            return node;
        if(cmp>0)
            return ceil(node.right,key);
        Node f = ceil(node.left, key);
        if(f!=null)
            return f;
        else
            return node;
    }

    public Key select(int i){
        Node node = select(root, i);
        return node.key;
    }

    private Node select(Node node,int i){
        if(node==null)
            return null;
        int rank = size(node.left);
        if(i<rank)
//            左子树从0开始
            return select(node.left,i);
        if(i>rank)
//            右子树排名要减掉左子树和根节点
            return select(node.right,i-rank-1);
        return node;
    }

    public int rank(Key key){
        return rank(root,key);
    }

    private int rank(Node node,Key key){
        if(node==null)
            return 0;
        int cmp =key.compareTo(node.key);
//        若当前节点大于目标结点,则不符合,继续去左子树中查找,缩小当前节点大小,缩减排名
        if(cmp<0)
            return rank(node.left,key);
//        若当前接点小于目标结点,则符合,且左子树都符合,排名就等于当前节点左子树所有节点个数+unit1,继续去右子树查找更大的符合条件的节点,扩大排名
        else if(cmp>0)
            return 1+size(node.left)+rank(node.right,key);
//        若找到了该节点,则返回以该节点为根子树节点个数
        else
            return size(node.left);
    }


}
