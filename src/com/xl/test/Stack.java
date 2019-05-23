package com.xl.test;

//下压堆栈
public class Stack<Item> {

    private Node first;
    private int N;

    private class Node{
        Item item;
        Node next;
    }

//  判断栈是否为空
    public boolean isEmpty(){
        return first == null;
    }

//  压栈
    public void push(Item item){
        Node oldNode = first;
        first = new Node();
        first.item = item;
        first.next = oldNode;
        N++;
    }

//  弹栈
    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

//  栈的大小
    public int size(){
        return N;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        System.out.println(stack.isEmpty());
        stack.push(2);
        System.out.println(stack.pop());
    }

}
