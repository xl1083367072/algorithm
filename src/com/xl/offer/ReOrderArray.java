package com.xl.offer;

import java.util.Arrays;

public class ReOrderArray {

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
     * @param array
     */
    public void reOrderArray(int [] array) {
        if(array==null||array.length==0)
            return;
        int start = 0;
        int end = array.length-1;
        while (start<end){
            while (start<end&&!isEvent(array[start])){
                start++;
            }
            while (start<end&&isEvent(array[end])){
                end--;
            }
            if(start<end){
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
    }

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
     * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * @param array
     */
    public static void reOrderArray2(int [] array) {
        if(array==null||array.length==0)
            return;
//        下一个奇数要插入的位置
        int index = 0;
//        遍历数组，找到奇数，然后将它插入合适位置，它之后的元素都后移一位，这样就保证了顺序
        for (int i=0;i<array.length;i++){
            if((array[i]&1)==1){
//                先记录奇数值，从后往前移动
                int odd = array[i];
                for (int j=i;j>index;j--){
                    array[j] = array[j-1];
                }
//                移动后，将奇数插入合适位置
                array[index] = odd;
//                移动到下一个位置
                index++;
            }
        }
    }

    private boolean isEvent(int num){
        return (num&1)==0;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        reOrderArray2(nums);
        System.out.println(Arrays.toString(nums));
    }

}
