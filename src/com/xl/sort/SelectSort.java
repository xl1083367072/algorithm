package com.xl.sort;


//选择排序,时间复杂度O(n²)
public class SelectSort {

    public static void sort(Comparable[] a){
//        需要遍历n次数组,每次从i开始遍历
        int N = a.length;
        for(int i=0;i<N;i++){
//            每次遍历开始，取此次遍历第一个数为最小值
            int min = i;
//            内循环,遍历i之后的值,找出最小值下标
            for(int j=i+1;j<N;j++){
//                如果发现有值比当前最小值小,则把此值下标设为最小值下标
                if(SortUtils.less(a[j],a[min])){
                    min = j;
                }
            }
//            一次外循环结束，就交换遍历起始位置上的值和之后的最小值
            SortUtils.exch(a,i,min);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {2,9,5,16,36,20,56,30,7,39,25,15,68,42,28,19};
        sort(arr);
        SortUtils.print(arr);
    }

}
