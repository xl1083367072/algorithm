package com.xl.offer;

//数字在排序数组中出现的次数
public class GetNumberOfK {

//    统计一个数字在排序数组中出现的次数。
    public int GetNumberOfK(int [] array , int k) {
        return biSearch(array, k+0.5) - biSearch(array, k-0.5) ;
    }


//    功能：定位到一个位置，这个位置的数字是第一个大于参数的位置
    private int biSearch(int[] data, double num){
        int s = 0, e = data.length-1;
        while(s <= e){
            int mid = (e - s)/2 + s;
            if(data[mid] < num)
                s = mid + 1;
            else if(data[mid] > num)
                e = mid - 1;
        }
        return s;
    }

//    第二种方法，找第一个和最后一个位置
    private static int getFirst(int[] array,int k,int start,int end){
        if(start>end)
            return -1;
        int mid = start + (end-start)/2;
        int num = array[mid];
        if(num == k){
            if(mid>0&&array[mid-1]!=k||mid==0)
                return mid;
            else
                end = mid-1;
        }else if(num > k){
            end = mid-1;
        }else {
            start = mid+1;
        }
        return getFirst(array,k,start,end);
    }

    private static int getLast(int[] array,int k,int start,int end){
        if(start>end)
            return -1;
        int mid = start + (end-start)/2;
        int num = array[mid];
        if(num == k){
            if(mid<array.length-1&&array[mid+1]!=k||mid==array.length-1)
                return mid;
            else
                start = mid+1;
        }else if(num > k){
            end = mid-1;
        }else {
            start = mid+1;
        }
        return getLast(array,k,start,end);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 3, 4, 5};
        int i = new GetNumberOfK().GetNumberOfK(array, 3);
        System.out.println(i);
        System.out.println(getLast(array,3,0,array.length-1)-getFirst(array,3,0,array.length-1)+1);
    }

}
