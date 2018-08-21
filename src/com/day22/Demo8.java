package com.day22;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 开发中的编码
 * 常用的字符集：GBK：2字节   ISO8859-1：1个字节  utf-8：3个字节  Unicode：2个字节(内部编码)
 * 说明：GBK，UTF-8是支持中文的，ISO8859-1不支持中文
 *
 *   编码:
 *  byte[] getBytes() //对于中文  默认是GBK
 * 使用平台的默认字符集将此 String 编码为 byte 序列，
 * 并将结果存储到一个新的 byte 数组中。
 *
 * byte[] getBytes(Charset charset)
   使用给定的 charset 将此 String 编码到 byte 序列，并将结果存储到新的 byte 数组。

   解码:
   String(byte[] bytes) //对于中文  默认是GBK
   通过使用平台的默认字符集解码指定的 byte 数组，构造一个新的 String。

   String(byte[] bytes, Charset charset)
   通过使用指定的 charset 解码指定的 byte 数组，构造一个新的 String。
 */
public class Demo8 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //使用GBK编码，GBK解码
        String str1 = "你好";
        byte[] bytes = str1.getBytes("GBK");
        System.out.println(new String(bytes,"GBK"));//你好
        System.out.println(Arrays.toString(bytes)); //[-60, -29, -70, -61]

        //使用utf-8编码，utf-8解码
        String str2 = "你好";
        byte[] bytes2 = str1.getBytes("utf-8");
        System.out.println(new String(bytes2,"utf-8"));//你好
        System.out.println(Arrays.toString(bytes2)); //[-28, -67, -96, -27, -91, -67]

        //使用ISO8859-1编码，ISO8859-1解码
        String str3 = "你好";
        byte[] bytes3 = str3.getBytes("ISO8859-1");
        System.out.println(new String(bytes3,"ISO8859-1"));//??
        System.out.println(Arrays.toString(bytes3)); //[63, 63]

    }
}
