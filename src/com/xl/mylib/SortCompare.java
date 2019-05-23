package com.xl.mylib;

import com.xl.sort.InsertSort;
import com.xl.sort.SelectSort;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

//排序性能比较工具
public class SortCompare {

//    返回不同算法的运行时间
    public static double time(String alg,Comparable[] a){
        Stopwatch time = new Stopwatch();
        if(alg.equals("select"))
            SelectSort.sort(a);
        if(alg.equals("insert"))
            InsertSort.sort(a);
        return time.elapsedTime();
    }

//    T个长度N的数组排序总时长
    public static double totalTime(String alg,int N,int T){
        Double[] arr = new Double[N];
        double total = 0.0;
        for(int i=0;i<T;i++){
            for(int j=0;j<N;j++){
                arr[j] = StdRandom.uniform();
            }
            total += time(alg,arr);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        System.out.println(alg1+"算法排序时长为"+alg2+"的"+totalTime(alg1,N,T)/totalTime(alg2,N,T)+"倍");
    }

}
