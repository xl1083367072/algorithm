package com.xl.offer;

//机器人的运功范围，考察回溯法
public class MovingCount {

    /**
     * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
     * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
     * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
     * @param threshold     k的值
     * @param rows
     * @param cols
     * @return
     */
    /**
     * 从起始格子开始向四周扩散，查看哪些格子可以到达
     * 从(0,0)开始，检查当前格子能不能访问
     * 若能访问，则达到格子数量+1，然后继续判断相邻格子是否能访问
     */
    public int movingCount(int threshold, int rows, int cols) {
        if(threshold<0||rows<1||cols<1)
            return 0;
        boolean[] visited = new boolean[rows*cols];
        int count = movingCount(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    private int movingCount(int threshold,int rows,int cols,int row,int col,boolean[] visited){
        int count = 0;
        if(check(threshold,rows,cols,row,col,visited)){
//            若能访问，设为已访问
            visited[row*cols+col] = true;
//            可到达格子数量加1，再加上相邻格子可到达的数量
            count = 1+movingCount(threshold,rows,cols,row-1,col,visited)
                    +movingCount(threshold,rows,cols,row+1,col,visited)
                    +movingCount(threshold,rows,cols,row,col-1,visited)
                    +movingCount(threshold,rows,cols,row,col+1,visited);
        }
        return count;
    }

//    检查当前格子能否访问
    private boolean check(int threshold,int rows,int cols,int row,int col,boolean[] visited){
//        若当前格子没有访问过，且行列数各位之和小于等于k值，则可以访问
        if(row>=0&&row<rows&&col>=0&&col<cols&&sum(row)+sum(col)<=threshold&&!visited[row*cols+col])
            return true;
        return false;
    }

//    计算一个数各位之和
    private int sum(int num){
        int sum = 0;
        while (num>0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }

}
