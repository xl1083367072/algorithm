package com.xl.mylib;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Locale;

public class StdOut {

//  本地化
    private static final Locale LOCALE = Locale.CHINA;

//  编码
    private static final String charset = "UTF-8";

//  文本输出流
    private static PrintWriter out;


    static{
        try{
            out = new PrintWriter(new OutputStreamWriter(System.out,charset),true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void printf(String format,Object value){
        out.printf(LOCALE,format,value);
        out.flush();
    }

}
