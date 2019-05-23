package com.xl.offer;

import java.util.ArrayList;

//顺时针打印矩阵
public class PrintMatrix {

    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
     * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
     * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        if(matrix==null||rows<=0||columns<=0)
            return null;
        ArrayList<Integer> result = new ArrayList<>();
//        每圈的起始坐标
        int start = 0;
//        每次循环打印一圈
        while (rows>2*start&&columns>2*start){
            printMatrixCircle(matrix,rows,columns,start,result);
            start++;
        }
        return result;
    }

    private void printMatrixCircle(int[][] martix,int rows,int columns,int start,ArrayList<Integer> result){
//        每圈终止行和列
        int endX = columns-1-start;
        int endY = rows-1-start;
//        每圈至少有一行，即使是一个元素，从左到右输出一行
        for (int i=start;i<=endX;i++){
            int num = martix[start][i];
            result.add(num);
        }
//        若至少有两行，则继续输出，从上到下输出一列
        if(start<endY){
            for (int i=start+1;i<=endY;i++){
                int num = martix[i][endX];
                result.add(num);
            }
        }
//        若至少有两行两列，则继续输出，从右到左输出一行
        if(start<endX&&start<endY){
            for (int i=endX-1;i>=start;i--){
                int num = martix[endY][i];
                result.add(num);
            }
        }
//        若至少有三行两列，则继续输出，从下到上输出一列
        if(endY-start>=2&&start<endX){
            for (int i=endY-1;i>start;i--){
                int num = martix[i][start];
                result.add(num);
            }
        }
    }

}
