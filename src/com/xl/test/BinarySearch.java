package com.xl.test;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class BinarySearch {


    //while循环方式
    public static int search(int[] array,int num){
        int left = 0;
        int right = array.length-1;
        while (left<=right){
            int mid = left + (right - left)/2;
            if(num>array[mid])
            {
                left = mid + 1;
            }
            else
                if(num<array[mid]){
                    right = mid - 1;
                }
                else
                    return mid;
        }
        return -1;
    }

//    递归方式
    public static int search(int[] arr,int left,int right,int num){
        if(left>right)
            return -1;
        int mid = left + (right - left)/2;
        if(num>arr[mid])
            left = mid + 1;
        else
            if(num<arr[mid])
                right = mid - 1;
            else
                return mid;
        return search(arr,left,right,num);
    }

    public static int simpleSearch(int arr[],int num){
        for (int i=0;i<arr.length;i++){
            if(num==arr[i])
                return i;
        }
        return -1;
    }


    /*public static void main(String[] args) {
        int[] array = {unit1,5,9,15,20,55,62,80};
//        int search = BinarySearch.search(array, 22);
        int search = BinarySearch.search(array,0,array.length-unit1,20);
        if(search==-unit1)
            System.out.println("没有找到该值");
        else
            System.out.println("找到了该值,下标是"+search);
    }*/
//经测试这里二分查找比暴力查找快了21秒
    public static void main(String[] args) {
        int[] array = In.readInts(args[0]);
        int search = 0;
//        System.out.println(Arrays.toString(array));
        long beforeTime = System.currentTimeMillis();
        Arrays.sort(array);
        for (int i=1000;i<array.length;i+=10){
             search += BinarySearch.search(array, i);
//        search += BinarySearch.simpleSearch(array, i);
        }
        long afterTime = System.currentTimeMillis();
//        int search = BinarySearch.search(array,0,array.length-unit1,20);
        System.out.println("下标是"+search);
        System.out.println("该算法总耗时:"+(afterTime-beforeTime));
    }

}
