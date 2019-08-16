package com.xl.offer;

//数组中只出现一次的数字
public class FindNumsAppearOnce {

    /**
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int length = array.length;
        if(array == null || length<2)
            return;
        int exclusive = 0;
        for (int i=0;i<length;i++){
            exclusive ^= array[i];
        }
        int index = findIndexOf1(exclusive);
        int num_1 = 0;
        int num_2 = 0;
        for (int j=0;j<length;j++){
            if(isIndexOf1(array[j],index)){
                num_1 ^= array[j];
            }else {
                num_2 ^= array[j];
            }
        }
        num1[0] = num_1;
        num2[0] = num_2;
    }

    private boolean isIndexOf1(int num, int index) {
        num = num >> index;
        return (num&1) == 1;
    }

    private int findIndexOf1(int exclusive) {
        int index = 0;
        while ((exclusive&1)==0&&index<32){
            exclusive = exclusive >> 1;
            index++;
        }
        return index;
    }

}
