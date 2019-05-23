package com.xl.search;


import com.xl.mylib.StdIn;

//符号表性能测试用例
public class FrequencyCounter {

    public static void main(String[] args) {
        int minlen = Integer.parseInt(args[0]);
//        ST<String,Integer> st = new ST<>();
//        SequentialSearchST<String,Integer> st = new SequentialSearchST<>();
//        BinarySearchST<String,Integer> st = new BinarySearchST<>();
//        BST<String,Integer> st = new BST<>();
        RedBlackBST<String,Integer> st = new RedBlackBST<>();
        StdIn stdIn = new StdIn("G:\\ideaWorkSpace\\arithmetic\\src\\com\\xl\\search\\text\\leipzig1M.txt");
        while (!stdIn.isEmpty()){
            String word = stdIn.readString();
            if(word.length()<minlen)
                continue;
            if(st.contains(word))
                st.put(word,st.get(word)+1);
            else
                st.put(word,1);
        }
        String maxcount = " ";
        st.put(maxcount,0);
        for (String word:st.keys()){
            if(st.get(word)>st.get(maxcount))
                maxcount = word;
        }
        System.out.println("出现次数最多的单词是"+maxcount+"出现次数是"+st.get(maxcount));
    }

}
