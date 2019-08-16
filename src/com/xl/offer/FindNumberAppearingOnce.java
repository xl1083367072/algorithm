package com.xl.offer;

//唯一只出现一次的数字
public class FindNumberAppearingOnce {

    /**
     * 其他数字都出现三次，只有一个数字出现一次
     * @param array
     * @return
     */
    public int FindNumberAppearingOnce(int[] array){
        if(array == null ||array.length<=0){
            return -1;
        }
        int[] bitSum = new int[32];
        for (int i=0;i<array.length;i++){
            int flag = 1;
            for (int j=31;j>=0;j--){
                if((array[i]&flag) != 0){
                    bitSum[j] += 1;
                }
                flag = flag << 1;
            }
        }
        int res = 0;
        for (int k=0;k<32;k++){
            res = res << 1;
            res += bitSum[k]%3;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,2,2,3,3,3};
        int i = new FindNumberAppearingOnce().FindNumberAppearingOnce(arr);
        System.out.println(i);
    }

}
