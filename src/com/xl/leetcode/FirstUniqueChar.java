package com.xl.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar {

    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     *
     * 案例:
     *
     * s = "leetcode"
     * 返回 0.
     *
     * s = "loveleetcode",
     * 返回 2.
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap();
        for (char c:s.toCharArray()){
//            用哈希表记录每个字符出现的次数
            if (map.containsKey(c)){
                int count = map.get(c);
                map.put(c,count+1);
            }else {
                map.put(c,1);
            }
        }
//        遍历字符串每个字符，找到第一个值为1的
        for (int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

}
