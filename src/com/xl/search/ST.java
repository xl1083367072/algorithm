package com.xl.search;

import java.util.Iterator;
import java.util.TreeMap;

public class ST<Key extends Comparable<Key>,Value> implements Iterable<Key>{

    private TreeMap<Key,Value> map;

    public ST(){
        map = new TreeMap<>();
    }

    public Value get(Key key){
        if(key==null)
            throw new IllegalArgumentException();
        return map.get(key);
    }

    public void put(Key key,Value value){
        if(key==null)
            throw new IllegalArgumentException();
        if(value==null)
            map.remove(key);
        map.put(key,value);
    }

    public void delete(Key key){
        if(key==null)
            throw new IllegalArgumentException();
        map.remove(key);
    }

    public boolean contains(Key key){
        if(key==null)
            throw new IllegalArgumentException();
        return map.containsKey(key);
    }

    public int size(){
        return map.size();
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public Iterable<Key> iterable(){
        return map.keySet();
    }

    public Iterator<Key> iterator(){
        return map.keySet().iterator();
    }

    public Key min(){
        if(isEmpty())
            throw new IllegalArgumentException();
        return map.firstKey();
    }

    public Key max(){
        if(isEmpty())
            throw new IllegalArgumentException();
        return map.lastKey();
    }

    public Key ceiling(Key key){
        if(key==null)
            throw new IllegalArgumentException();
        key = map.ceilingKey(key);
        if(key==null)
            throw new IllegalArgumentException();
        return key;
    }

    public Key floor(Key key){
        if(key==null)
            throw new IllegalArgumentException();
        key = map.floorKey(key);
        if(key==null)
            throw new IllegalArgumentException();
        return key;
    }

}
