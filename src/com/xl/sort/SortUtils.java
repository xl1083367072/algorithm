package com.xl.sort;

//排序工具类
public class SortUtils {

//    若第一个值小于第二个则返回true,否则返回false
    public static boolean less(Comparable a,Comparable b){
        return a.compareTo(b) < 0;
    }

//    交换两个值
    public static void exch(Comparable a[],int i,int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

//    验证数组是否有序
    public static boolean isSort(Comparable a[]){
        for (int i = 1; i<a.length; i++) {
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }

//    输出数组
    public static void print(Comparable a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"  ");
        }
    }

}
