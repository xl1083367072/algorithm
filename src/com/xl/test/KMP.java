package com.xl.test;

import java.util.Arrays;

//kmp算法
public class KMP {

    public static int[] getNext(int next[],String substr){

        int i=1,j=0;
        next[i]=j;

        while(j==0||i<substr.length()){

            if(substr.charAt(i)==substr.charAt(j))
                next[++i] = ++j;
            else
                j = next[j];

        }
        return next;


    }

    public static void main(String[] args) {
        String str = "abcdecd";
        String substr = "abababa";
        int next[] = new int[str.length()];
        int[] ints = getNext(next, substr);
        System.out.println(Arrays.toString(ints));
        int i = 0;
        int j = 0;
        while(i<str.length()&&j<substr.length()){
            if(str.charAt(i)==substr.charAt(j)){
                ++i;
                ++j;
            }else {
                j = ints[j];
            }
        }
    }


}
