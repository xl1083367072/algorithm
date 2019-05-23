package com.xl.sort;

//快速排序
public class QuickSort {

//    分治思想
    public static int partition(Comparable[] a,int lo,int hi){
//        先取左边扫描的指针
        int i = lo;
//        因为从右向左扫描时是先-的
        int j = hi+1;
//        再取切分元素
        Comparable v = a[lo];
//      外层循环,每次循环,就将比切分元素大的移到右边,小的移到左边,直到左边都比切分元素小,右边都比切分元素大时停止
        while(true){
//            从左向右扫描,直到找到一个比切分元素大的值时停止,或者扫描到最右端停止
            while (SortUtils.less(a[++i],v))
                if(i==hi)
                    break;
//            从右向左扫描,直到找到一个比切分元素小的值时停止,或者扫描到最左端停止
            while (SortUtils.less(v,a[--j]))
                if(j==lo)
                    break;
//              当左右指针相遇时停止,左右都变得有序了
            if(i>=j)
                break;
//            交换本次循环左右两边元素
            SortUtils.exch(a,i,j);
        }
//        将切分元素移动到合适位置
        SortUtils.exch(a,lo,j);
//        返回切分位置
        return j;
    }

//    递归,分治思想,切分成两边,归并排序是切分成两等分
    public static void sort(Comparable[] a,int lo,int hi){
        if(lo>=hi)
            return;
        int i = partition(a, lo, hi);
//        切分左边
        sort(a,lo,i-1);
//        切分右边
        sort(a,i+1,hi);
    }

//    三向切分,直到满足lo-lt小于切分元素,lt-gt等于切分元素,gt-hi大于切分元素为止
    public static void sort3Way(Comparable[] a,int lo,int hi){
//        递归结束条件
        if(hi<=lo)
            return;
//        lo-lt都是小于切分元素的,lt-i都是等于切分元素的
        int lt = lo;
//        i-gt都是还未比较的元素
        int i = lo+1;
//        gt-hi都是大于切分元素的
        int gt = hi;
//        取第一个为每次的切分元素
        Comparable v = a[lo];
//        当i和gt相遇则此次切分结束
        while(i<=gt){
//            i是当前需要比较的元素,得出比较结果
            int result = a[i].compareTo(v);
//            若当前比较元素小于切分元素,则交换到lo-lt小于切分元素的集合中,lt后移存放下一个小于切分元素的元素
            if(result<0)
                SortUtils.exch(a,i,lt++);
//            若当前元素大于切分元素,则交换到gt-hi大于切分元素的集合中,gt前移存放下一个大于切分元素的元素
            else if(result>0)
                SortUtils.exch(a,i,gt--);
//            否则,就是等于切分元素,此元素不用移动,拉开lt和i之间的距离,后移继续比较
            else
                i++;
        }
//        递归,继续下一轮切分,等于部分不用切分了,所以效率也会比普通快排要高,更稳定
        sort3Way(a,lo,lt-1);
        sort3Way(a,gt+1,hi);
    }

    public static void main(String[] args) {
        Integer[] arr = {2,9,5,16,36,20,56,30,7,39,25,15,68,42,28,19};
        sort3Way(arr,0,arr.length-1);
        SortUtils.print(arr);
    }


}
