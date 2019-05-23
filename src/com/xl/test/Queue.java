package com.xl.test;

//队列
public class Queue<Item> {

    private Node first;
    private Node last;
    private int N;

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

//    入队
    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()){
            first = last;
        }else {
            oldLast.next = last;
        }
        N++;
    }

//    出队
    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        if(isEmpty())
            first = last;
        N--;
        return item;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        System.out.println(queue.isEmpty());
        System.out.println(queue.dequeue());
        System.out.println(queue.size());
    }

}
