package com.xl.sort;

//希尔排序
public class ShellSort {

    public static void sort(Comparable[] a){
        int h = 1;
        int N = a.length;
//        希尔排序关键在于h有序,先得出h的取值
        while(h<N/3)
            h = 3*h+1;
//        最终h是1,就相当于插入排序了,只不过经过之前的调整已经部分有序了,有助于插入排序的性能
        while(h>=1){
//            第二层循环,从第h个元素开始,每个元素要每隔h一组的数中有序
            for(int i=h;i<N;i++){
//                第三层循环,每隔h间隔进行比较,最终h有序
                for (int j=i;j>=h&&SortUtils.less(a[j],a[j-h]);j-=h){
                    SortUtils.exch(a,j,j-h);
                }
            }
            h = h/3;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {2,9,5,16,36,20,56,30,7,39,25,15,68,42,28,19};
        sort(arr);
        SortUtils.print(arr);
    }

}
