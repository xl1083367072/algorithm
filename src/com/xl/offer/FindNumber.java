package com.xl.offer;

//二维数组中的查找，考察数组
public class FindNumber {

    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */
    public static boolean Find(int target, int [][] array) {
//        获取行数
        int rows = array.length;
//        获取列数
        int cols = array[0].length;
//        当前右上角数所在行和列
        int row = 0,col = cols-1;
//        循环比较右上角数和目标值
        while (row<rows&&col>=0){
//            若相等，则返回
            if(array[row][col]==target)
                return true;
//            右上角数大于目标值，则它所在的列都大于目标值，排除掉此列
            else if(array[row][col]>target)
                col--;
//            右上角数小于目标值，则它所在行都小于目标值，排除此行
            else
                row++;
        }
        return false;
    }

    public static void main(String[] args) {
    }

}
