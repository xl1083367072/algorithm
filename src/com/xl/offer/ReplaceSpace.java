package com.xl.offer;

//替换空格，考察字符串
public class ReplaceSpace {

    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str) {
//        一般返回空串
        if(str==null||str.length()==0)
            return "";
//        原字符串长度
        int originalLength = str.length()-1;
//        空白字符长度
        int blankLength = 0;
//        统计空白字符
        for (int i=0;i<str.length();i++){
            if(str.charAt(i)==' ')
                blankLength++;
        }
//        算出空白字符被替换后的最终字符长度
        int newLength = originalLength + 2*blankLength;
//        设置为新长度
        str.setLength(newLength+1);
//        两个指针向前搜索，后面指针碰到前面指针，就替换完毕了
        while (originalLength>=0&&newLength>originalLength){
//            若前指针指向的是空白字符
            if(str.charAt(originalLength)==' '){
//                则后指针依次设置为%20
                str.setCharAt(newLength--,'0');
                str.setCharAt(newLength--,'2');
                str.setCharAt(newLength--,'%');
            }else {
//                否则，将前指针指向字符放到后指针指向位置
                str.setCharAt(newLength--,str.charAt(originalLength));
            }
//            前指针向前移动
            originalLength--;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("We Are Happy")));
    }

}
