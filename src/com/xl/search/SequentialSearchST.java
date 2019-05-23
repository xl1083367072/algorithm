package com.xl.search;

import edu.princeton.cs.algs4.Queue;

//基于无序链表的顺序查找
//O(n)=N
public class SequentialSearchST<Key,Value> {

//    头节点,当插入新节点时,此节点就是新插入的节点
    private Node first;
    private int count;

    private class Node{
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

//    根据键取值,从头结点开始遍历链表,若找到与键相等的节点,则返回值,否则没有此键返回空
    public Value get(Key key){
        if(key==null)
            throw new IllegalArgumentException();
        for (Node node=first;node!=null;node=node.next){
            if(node.key.equals(key))
                return node.value;
        }
        return null;
    }

//    设置键,从头结点开始遍历链表,若找到相同的键则修改值,否则创建新节点放在头部
    public void put(Key key,Value value){
        if(key==null)
            throw new IllegalArgumentException();
        if(value==null){
            delete(key);
            return;
        }

        for (Node node = first;node!=null;node=node.next){
            if(node.key.equals(key)){
                node.value = value;
                return;
            }
        }
        first = new Node(key,value,first);
        count++;
    }

    public int size(){
        return count;
    }

    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<>();
        for (Node node=first;node!=null;node=node.next){
            queue.enqueue(node.key);
        }
        return queue;
    }

    public void delete(Key key){
        if(key==null)
            throw new IllegalArgumentException();
        first = delete(first,key);
    }

    private Node delete(Node node,Key key){
        if(key==null)
            return null;
        if(node.key.equals(key)){
            count--;
            return node.next;
        }
//        如果找到要删除的节点会把该节点的下一个节点返回给该节点的上一个节点,即断开了该节点的前后连接
//        如果不是要删除的节点,则将该节点的引用正常返回给上一个节点,依次向上返回
        node.next = delete(node.next,key);
        return node;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public boolean contains(Key key){
        if(key==null)
            throw new IllegalArgumentException();
        return get(key)!=null;
    }


}
