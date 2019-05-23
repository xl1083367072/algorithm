package com.xl.offer;

//旋转数组中的最小数字，考察二分查找
public class MinNumberInRotateArray {

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     * @param array
     * @return
     */
//    二分查找法
//    旋转后的数组分为两个有序数组
    public static int minNumberInRotateArray(int [] array) {
//        左右指针，左指针在左边有序数组中，右指针在右边有序数组中
        int left = 0,right = array.length-1,mid=0;
//        若本身是有序的，则直接输出第一个元素
        while (array[left]>=array[right]){
//            若左右指针相邻，则左指针值指向了左边有序数组中的最右边的元素，右指针指向右边有序数组中的最左边的元素
//            此时右指针位置元素就是最小值
            if(left+1==right){
                mid = right;
                break;
            }
//            否则，取中间位置
            mid = left + (right-left)/2;
//            这里是为了判断若出现左中右三个指针元素相等情况，此时无法判断应该分到哪一边
            if(array[left]==array[right]&&array[left]==array[mid]){
//                所以从左指针到右指针之间元素顺序查找
                getMin(array,left,right);
            }
//            若左指针元素小于等于中间元素，则说明此时中间元素在左边有序数组中，所以去右半部分查找
            if(array[left]<=array[mid]){
                left = mid;
//                否则去左半部分查找
            }else if(array[right]>=array[mid]){
                right = mid;
            }
        }
        return array[mid];
    }

//    顺序查找找到最小值
    private static int getMin(int[] array,int left,int right){
        int result = array[left];
        for (int i=left+1;i<=right;i++){
            if(array[i]<result)
                result = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1,1};
        System.out.println(minNumberInRotateArray(nums));
    }

}
