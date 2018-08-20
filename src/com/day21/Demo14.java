package com.day21;

import java.io.*;

public class Demo14 {
    public static void main(String[] args) throws IOException {
    /*
    打印流：
    字节打印流：PrintStream：除了拥有输出流的特点外，还有打印的功能
    字符打印流：PrintWriter：
    字节打印流支持的设备：
    1.File类型的文件
    2.字符串类型的文件
    3.字节输出流

     */
//    1.File类型的文件
        PrintStream printStream1 = new PrintStream(new File("temp1.txt"));
//    2.字符串类型的文件
        PrintStream printStream2 = new PrintStream("temp1.txt");
//    3.字节输出流
        PrintStream printStream3 = new PrintStream(new FileOutputStream("temp1.txt"));
    //讲解print()
        PrintStream printStream4 = new PrintStream(new FileOutputStream("temp6.txt"));
        printStream4.write(97);//a  00000000 00000000 00000000 01100001
        printStream4.write(353);//a 00000000 00000000 00000001 01100001

        printStream4.print(353); //进行了自动转化
        //先将353转成字符串，再转成字节数组
        printStream4.write(String.valueOf(353).getBytes());
        printStream4.close();
    }
}
