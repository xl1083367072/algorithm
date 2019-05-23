package com.xl.offer;

//矩阵中的路径，考察回溯法
public class HasPath {

    /**
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
     * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
     * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
     * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
     * @param matrix    目标矩阵
     * @param rows      行
     * @param cols      列
     * @param str       目标字符串
     * @return
     */
    /**
     * 选取矩阵中任意一个字符作为循环起始字符，判断与目标字符串的第1个字符是否相等
     * 若相等，则继续取这个字符的相邻字符，即上下左右字符与目标字符串的下一个字符进行比较
     * 若有一个是相等的，则继续取相邻字符，直到与目标字符串的最后一个字符也相等，则匹配成功
     * 若匹配过程中有一个字符的相邻字符与目标字符串当前位置字符不等，则回溯到上一个字符，重新匹配，说明这条路走不通
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(matrix==null||rows<1||cols<1||str==null)
            return false;
//        存储各个位置字符是否被访问过了，访问过的不能再访问
        boolean[] visited = new boolean[rows*cols];
//        目标字符串要匹配字符的当前位置
        int pathLength = 0;
//        循环以每一个字符为起始字符，尝试匹配
        for (int row=0;row<rows;row++){
            for (int col=0;col<cols;col++){
//                以row行col列字符为起始字符是否能匹配成功
                if(hasPath(matrix,rows,cols,row,col,str,pathLength,visited))
                    return true;
            }
        }
        return false;
    }

//    真正进行字符匹配的函数
    private static boolean hasPath(char[] matrix,int rows,int cols,int row,int col,char[] str,int pathLength,boolean[] visited){
//        若匹配到了str.length位置，则说明匹配完成了
        if(pathLength==str.length)
            return true;
//        当前字符和当前字符的相邻字符是否能匹配
        boolean hasPath = false;
//        若当前字符可以和目标字符匹配，且没有被访问过
        if(row>=0&&row<rows&&col>=0&&col<cols&&matrix[row*cols+col]==str[pathLength]&&!visited[row*cols+col]){
//            目标字符后移一位
            pathLength++;
//            当前字符设为已访问
            visited[row*cols+col] = true;
//            匹配当前的字符的相邻字符
            hasPath = hasPath(matrix,rows,cols,row-1,col,str,pathLength,visited)
                    ||hasPath(matrix,rows,cols,row+1,col,str,pathLength,visited)
                    ||hasPath(matrix,rows,cols,row,col-1,str,pathLength,visited)
                    ||hasPath(matrix,rows,cols,row,col+1,str,pathLength,visited);
//            若相邻字符都不匹配
            if(!hasPath){
//                回溯到上一个字符，重新匹配
                pathLength--;
//                当前字符设为未访问
                visited[row*cols+col] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        char[] matrix = {'a','b','t','g','c','f','c','s','j','d','e','h'};
        char[] str = {'b','f','c','e'};
        System.out.println(hasPath(matrix,3,4,str));
    }


}
