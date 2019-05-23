package com.xl.sort;

//堆排序
public class HeapSort {

//        重写下沉方法,堆排序一直在从最后一个元素开始向前移动数组指针,所以N是变化的,代表最后一个元素
    public static void sink(Comparable[] a,int k,int N){
//        N是数组最后一位,等于N也有孩子节点
        while(2*k<=N){
//            取左孩子节点
            int j = 2*k;
//            要加上j<N,因为有和右孩子节点比较,右孩子节点要+unit1,如果=N,即没有右孩子节点,不需要比较了
            if(j<N&&SortUtils.less(a[j],a[j+1]))
                j++;
            if(!SortUtils.less(a[k],a[j])){
                break;
            }
            SortUtils.exch(a,k,j);
            k = j;
        }
    }

//    堆排序
    public static void sort(Comparable[] a){
        int N = a.length-1;
//        构造堆,从有孩子节点的节点开始下沉,最后就构造成了堆
        for(int i=N/2;i>=1;i--){
            sink(a,i,N);
        }
//        最后一个元素不需要在交换和下沉了
        while (N>1){
//            上面已经构造出了堆,根元素就是最大元素,每次交换根和最后一个元素,数组指针向前移一位,依次剔除最大元素
            SortUtils.exch(a,1,N--);
//            再对根元素下沉,修复堆,如此往复
            sink(a,1,N);
        }
    }

    public static void main(String[] args) {
//        堆排序,第一个元素不用,根从第二个开始,下标是1
        Comparable[] a = {null,2,9,5,16,36,20,56,30,7,39,25,15,68,42,28,19};
        sort(a);
        SortUtils.print(a);
    }

}
