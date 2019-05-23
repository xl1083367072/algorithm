package com.xl.offer;

//数组中的重复数字，考察数组
public class Duplicate {

    /**
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字是重复的。
     * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
     * @param numbers       目标数组
     * @param length        目标数组长度
     * @param duplication   放入任意一个重复数字
     * @return
     */
//    重点：在一个长度为n的数组里的所有数字都在0到n-1的范围内
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null||length==0){
            return false;
        }
        for (int i=0;i<length;i++){
            if(numbers[i]<0||numbers[i]>length-1){
                return false;
            }
        }
//        可以用HashMap做，这样空间复杂度是O(n)
//        遍历一遍数组，找出重复数字，时间复杂度O(n),空间复杂度O(1)
        for (int i=0;i<length;i++){
//            循环将每个数放入数组的对应索引位置上，若数组中没有重复数字，应该是每个数字在对应索引位置上
//            若有重复数字，则一定有一个不在对应索引位置上的数和一个在索引位置上的数，此时就发现重复了
            while (numbers[i]!=i){
//                若发现重复，则返回结果
                if(numbers[i]==numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }
//                否则就将这个位置上的数放入它对应的索引位置上
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }

//    不修改数组找出重复数字
//    数组长度是n+1，数的范围是1-n
    public static int duplicate(int numbers[],int length) {
        if(numbers==null||length==0)
            return -1;
//        数的范围是1-n
        int start = 1;
        int end = length-1;
//        最终是一个数字时停止循环
        while (end>=start){
//            取中间值
            int middle = start + ((end-start)>>1);
//            计算数组中，在这两数之间数的个数
            int count = getRangeCount(numbers, length, start, middle);
//            当最后划分到只剩一个数字时
            if(start==end){
//                且这个数字个数大于1，则找到重复数字
                if(count>1)
                    return start;
                else
                    break;
            }
//            若start-middle之间数个个数大于不重复时两数之间个数，则去这个区间继续查找重复数字
            if(count>middle-start+1)
                end = middle;
//            否则取另一边查找
            else
                start = middle + 1;
        }
        return -1;
    }

    private static int getRangeCount(int[] numbers,int length,int start,int end){
        int count = 0;
        for (int i=0;i<length;i++){
            if(numbers[i]>=start&&numbers[i]<=end){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,0,2,5,3};
        int[] result = new int[1];
        /*boolean duplicate = duplicate(nums, nums.length, result);
        if(duplicate)
            System.out.println(Arrays.toString(result));*/
        int duplicate = duplicate(nums, nums.length);
        System.out.println(duplicate);
    }

}
