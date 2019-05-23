package com.xl.sort;

//插入排序,时间复杂度O(n²)
public class InsertSort {

//交换元素法
    public static void sort(Comparable[] a){
        int  N = a.length;
//        外循环主要控制当前要插入进有序数组的数,当前索引之前的数都是有序的,当到最后一个索引时,即排序完成
        for(int i=1;i<N;i++){
//            内循环主要控制当前索引的值插入到有序数组中哪个位置,因为之前的数组都是有序的,所以一旦有比当前索引值小的就不用继续排了
//            否则继续向前搜寻更合适的位置插入
            for(int j=i;j>0&&SortUtils.less(a[j],a[j-1]);j--){
                SortUtils.exch(a,j-1,j);
            }
        }
    }

//  把大的元素向后移动,经测试这个优化后的插入排序性能高的多
    public static void sort2(Comparable[] a){
        int N = a.length;
        for(int i=1;i<N;i++){
//            先记录当前数组索引值
            Comparable current = a[i];
//            获取当前索引
            int index = i;
//            向前搜索，如果前面有值比当前值小，就往后移一位，直到找到一个比当前值大的值
            while(index>0&&SortUtils.less(current,a[index-1])){
                a[index] = a[index-1];
                index--;
            }
//            插入在当前位置上
            a[index] = current;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {2,9,5,16,36,20,56,30,7,39,25,15,68,42,28,19};
        sort2(arr);
        SortUtils.print(arr);

    }

}
