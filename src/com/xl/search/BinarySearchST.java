package com.xl.search;

import edu.princeton.cs.algs4.Queue;

//基于有序数组的二分查找
//O(n)=logN,插入N
public class BinarySearchST<Key extends Comparable<Key>,Value> {

    private Key[] keys;
    private Value[] vals;
    private int N;
    private static final int CAPACITY = 2;

    public BinarySearchST() {
        this(CAPACITY);
    }

    public BinarySearchST(int capacity) {
        this.keys = (Key[]) new Comparable[capacity];
        this.vals = (Value[]) new Comparable[capacity];
    }

//    如果key存在,则返回key的位置,如果key不存在,则返回比key小的key数量,即应该插入的位置
    public int rank(Key key){
        int lo = 0,hi = N-1;
        while (lo<=hi){
            int mid = lo + (hi-lo)/2;
            int camp = key.compareTo(keys[mid]);
//            若未命中,则最后一次比较只有两个位置,lo,hi
//            最后一次比较时,若lo键大于查找的键,则此位置就是最终结果
            if(camp<0)
                hi = mid-1;
//            最后一次比较时,若lo键小于查找的键,则下一个位置即hi的位置就是最终结果
            else if(camp>0)
                lo = mid+1;
            else
                return mid;
        }
        return lo;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public boolean contains(Key key){
        if(key==null)
            throw new IllegalArgumentException();
        return get(key)!=null;
    }

    public Value get(Key key){
        if(isEmpty())
            return null;
        if(key==null)
            throw new IllegalArgumentException();
        int rank = rank(key);
//        若该键应在位置小于数组长度且确实和查找的键相等则返回对应位置的值
        if(rank<N&&key.equals(keys[rank]))
            return vals[rank];
        else
            return null;
    }

    public void put(Key key,Value value){
        if(key==null)
            throw new IllegalArgumentException();
//        若值空,则删除键
        if(value==null){
            delete(key);
            return;
        }
//        若存在该键则修改值
        int rank = rank(key);
        if(rank<N&&key.compareTo(keys[rank])==0){
            vals[rank] = value;
            return;
        }
//        在添加新键之前检查数组大小,每次扩容为原来两倍
        if(N==keys.length)
            resize(keys.length*2);
//        插入新键值对
        for (int j=N;j>rank;j--){
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[rank] = key;
        vals[rank] = value;
        N++;
    }

    public void delete(Key key){
        if(key==null)
            throw new IllegalArgumentException();
        int rank = rank(key);
//        若不存在该键
        if(rank>=N||key.compareTo(keys[rank])!=0)
            return;
//        注意溢出,N-unit1,若存在该键则移动值的位置
        for (int j=rank;j<N-1;j++){
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }
        N--;
//        移动过后最后一个位置是多出来的值,设空
        keys[N] = null;
        vals[N] = null;
//        删除后,若数组长度为原来1/4,则缩减数组长度
        if(N>0&&N==keys.length/4)
            resize(keys.length/2);

    }

    public void resize(int length){
//        新数组长度必须大于等于原数组元素个数
        assert length>=N;
        Key[] tempKeys = (Key[]) new Comparable[length];
        Value[] tempVals = (Value[]) new Comparable[length];
        for (int i=0;i<N;i++){
            tempKeys[i] = keys[i];
            tempVals[i] = vals[i];
        }
        keys = tempKeys;
        vals = tempVals;
    }

    public Key min(){
        if(isEmpty())
            throw new IllegalArgumentException();
        return keys[0];
    }

    public Key max(){
        if(isEmpty())
            throw new IllegalArgumentException();
        return keys[N-1];
    }

    public void deleteMin(){
        delete(min());
    }

    public void deleteMax(){
        delete(max());
    }

//    根据下标
    public Key select(int index){
        if(index<0||index>=N)
            throw new IllegalArgumentException();
        return keys[index];
    }

    public Iterable<Key> keys(){
        return keys(min(),max());
    }

    public Iterable<Key> keys(Key lo,Key hi){
        if(lo==null || hi==null)
            throw new IllegalArgumentException();
        Queue<Key> queue = new Queue<>();
        if(lo.compareTo(hi)>0)
            return queue;
        int rank = rank(hi);
//        将lo到hi位置之间的key入队
        for (int i=rank(lo);i<rank;i++)
            queue.enqueue(keys[i]);
        if(contains(hi))
            queue.enqueue(keys[rank(hi)]);
        return queue;
    }

}
