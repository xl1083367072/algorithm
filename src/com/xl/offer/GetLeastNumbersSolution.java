package com.xl.offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbersSolution {

    /**
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(input==null||input.length<k||k<1)
            return result;
//        用大顶堆存放k个数
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i=0;i<input.length;i++){
//            堆中小于k个数时，直接加入
            if(priorityQueue.size()<k){
                priorityQueue.add(input[i]);
            }else {
//                否则，若新插入的数比堆中最大的数小，则替换掉最大数
                if(input[i]<priorityQueue.peek()){
                    priorityQueue.poll();
                    priorityQueue.add(input[i]);
                }
            }
        }
//        最后剩的k个数就是最小的k个数
        result.addAll(priorityQueue);
        return result;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(2);
        queue.add(1);
        queue.add(5);
        queue.add(3);
        System.out.println(queue.poll()+""+queue.size());
    }

}
