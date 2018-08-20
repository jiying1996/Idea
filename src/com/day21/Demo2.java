package com.day21;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
字符流：  传输的是字符，只能传输字符
    字符写出流  Writer
        write(), write(字符数组), write(字符串)
    字符写入流  Reader
        read(), read(数组)
     字符缓冲写出流 BufferedWriter
        newLine() 快平台换行
     字符缓冲写入流 BufferedReader
        readLine() 读一行
字节流：  传输的是字节，可以传输任何类型的数据
        字节输出流       OutputStream
        字节输入流       InputSteam
        字节缓冲输出流     BufferedOutputStream
        字节缓冲输入流     BufferedInputStream
 */
public class Demo2 {
    public static void main(String[] args) throws IOException {
        //先讲字节流
        //实现写
//        fileWrite();
        //实现读1
//        fileReader1();
        //实现读2
//        fileReader2();
        //实现读3
        fileReader3();
    }
    //实现写
    public static void fileWrite() throws IOException {
        //1.创建输出流对象并关联文件
        FileOutputStream fileOutputStream = new FileOutputStream("temp01.txt");
        //2.写  因为使用的是字节流，所以不能直接传输字符，要进行编码
        fileOutputStream.write("bingbing".getBytes());//对应的默认字符集为GBK
        //3.刷新+关闭流
        fileOutputStream.close();
    }
    //实现读1:一个字节一个字节的读
    public static void fileReader1() throws IOException {
        //1.创建输入流对象
        FileInputStream fileInputStream = new FileInputStream("temp01.txt");
        //2.读
        int num = 0;
        while ((num = fileInputStream.read())!=-1){
            System.out.print((char)num);
        }
        fileInputStream.close();
    }
    //实现读2：一次读取多个字节
    public static void fileReader2() throws IOException {
        //1.创建输入流对象
        FileInputStream fileInputStream = new FileInputStream("temp01.txt");
        //2.读
        byte[] bytes = new byte[3];
        int num = -1;
        while ((num = fileInputStream.read(bytes))!=-1){
            System.out.print(new String(bytes,0,num));
        }
        fileInputStream.close();
    }
    //实现读3：一次读取全部字节
    public static void fileReader3() throws IOException {
        //1.创建输入流对象
        FileInputStream fileInputStream = new FileInputStream("temp01.txt");
        //2.获取所有的字节数
        //注意：如果文本的字节数太大不建议使用
        int nums = fileInputStream.available();
        //3.读
        byte[] bytes = new byte[nums];
        fileInputStream.read(bytes);
        System.out.print(new String(bytes));
        //4.关闭流
        fileInputStream.close();
    }
}
