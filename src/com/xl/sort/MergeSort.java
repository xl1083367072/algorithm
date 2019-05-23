package com.xl.sort;


//归并排序
public class MergeSort {

    private static Comparable[] aux;

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }

//    原地归并的抽象方法
    public static void merge(Comparable[] a,int lo,int mid,int hi){
        int i = lo;
        int j = mid+1;
        for(int k=lo;k<=hi;k++){
            aux[k] = a[k];
        }
        for(int k=lo;k<=hi;k++) {
//            若左边用尽取右边元素
            if (i > mid)
                a[k] = aux[j++];
//            若右边元素用尽取左边元素
            else if (j > hi)
                a[k] = aux[i++];
//            若右边元素小取右边的
            else if (SortUtils.less(aux[j], aux[i]))
                a[k] = aux[j++];
//            否则取左边的
            else
                a[k] = aux[i++];
        }
    }

//    分治思想,自顶向下归并排序
    public static void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo)
            return;
        int mid = lo + (hi-lo)/2;
//        左边归并
        sort(a,lo,mid);
//        右边归并
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

//  自底向上,先从最小的组即一个一组两组归并,再逐渐翻倍组的大小,直至最后归并最大的
    public static void sort1(Comparable[] a){
        int N = a.length;
        aux = new Comparable[N];
//        外层循环,控制每组大小,unit1,2,4...
        for(int sz=1;sz<N;sz=sz+sz){
//            内层循环,循环变量是每组最左边的下标,然后通过每组大小计算出每组的中间下标和最右边下标,进行归并
            for(int lo=0;lo<N-sz;lo+=sz+sz){
                merge(a,lo,lo+sz-1, Math.min(lo+sz+sz-1,N-1));
            }
        }
    }

    public static void main(String[] args) {
        Comparable[] a = {2,9,5,16,36,20,56,30,7,39,25,15,68,42,28,19};
        sort1(a);
        SortUtils.print(a);
    }

}
