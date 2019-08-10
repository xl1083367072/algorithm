package com.xl.offer;

//数组中的逆序对
public class InversePairs {

    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
     * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
     * 输入描述:
     * 题目保证输入的数组中没有的相同的数字
     *
     * 数据范围：
     *
     * 	对于%50的数据,size<=10^4
     *
     * 	对于%75的数据,size<=10^5
     *
     * 	对于%100的数据,size<=2*10^5
     * @param array
     * @return
     */
    public int InversePairs(int [] array) {
        if(array.length<=0||array==null)
            return 0;
        int[] copy = new int[array.length];
        for (int i=0;i<array.length;i++)
            copy[i]=array[i];
        return InversePairs(array,copy,0,array.length-1);
    }

    private int InversePairs(int[] array,int[] copy,int start,int end){
        if(start==end)
            return 0;
        int mid = start+(end-start)/2;
        int left = InversePairs(array,copy,start,mid);
        int right = InversePairs(array,copy,mid+1,end);
        int i = mid;
        int j = end;
        int index = end;
        int count = 0;
        while (i>=start&&j>=mid+1){
            if(array[i]>array[j]){
                copy[index--] = array[i--];
                count += j-mid;
            }else {
                copy[index--] = array[j--];
            }
        }
        for (;i>=start;i--){
            copy[index--] = array[i];
        }
        for (;j>=mid+1;j--){
            copy[index--] = array[j];
        }
        return (left+right+count)%1000000007;
    }

}
