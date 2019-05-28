package com.xl.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

//字符串的排列
public class Permutation {

    /**
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if(str!=null&&str.length()>0){
            PermutationHelper(str.toCharArray(),0,result);
            Collections.sort(result);
        }
        return result;
    }

//    递归
    private void PermutationHelper(char[] chars,int i,ArrayList<String> result){
//        组合出来一种排列
        if(i==chars.length-1){
            result.add(String.valueOf(chars));
        }else {
            HashSet<Character> set = new HashSet<>();
            for (int j=i;j<chars.length;j++){
                if(!set.contains(chars[j])||j==i){
//                    处理重复字符
                    set.add(chars[j]);
//                    求所有可能得第一个字符
                    swap(chars,i,j);
//                    固定第一个字符，再递归求出第二个字符的所有可能组合，
//                    然后其他字符一样，固定一个字符求出后一个字符的所有可能组合
                    PermutationHelper(chars,i+1,result);
//                    将上面交换的再交换回来，继续求其他可能出现在这一位的其他字符
                    swap(chars,j,i);
                }
            }

        }
    }

    private void swap(char[] chars,int i,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
