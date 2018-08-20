package com.day21;

import java.io.*;

/**
 * 标准输入流：System.in:次流已经被打开了，准备提供数据，默认对应于键盘的输入（输入源）或者由主机或用户指定的另一个输入源
 * 标准输出流：System.out
 */
public class Demo5 {
    public static void main(String[] args) throws IOException {
        //标准输入流 出发点：键盘  目的地：内存
        InputStream inputStream = System.in;
        //这里可以直接得到标准输入流对象，并已经绑定了键盘，可以从键盘接受数据
        //注意点：标准输入流是一个字节流
//        int num = inputStream.read(); //阻塞式方法，会一直等待用户输入
//        System.out.println((char)num);
        /*
        实例：从键盘一直接收字节的程序
        要求：一行一行的接收
         */
        myReadLine(inputStream);
        inputStream.close();
    }

    public static void myReadLine(InputStream inputStream) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true){
            int num = inputStream.read();
            if(num == '\r'){
                continue;
            }else if(num == '\n'){
                System.out.println(stringBuffer.toString());
                //当输入over的时候，结束
                if(stringBuffer.toString().equals("over")){
                    break;
                }
                stringBuffer.delete(0,stringBuffer.length());
            }else{
                stringBuffer.append((char)num);
            }
        }
    }
}
