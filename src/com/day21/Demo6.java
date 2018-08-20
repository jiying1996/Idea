package com.day21;

import java.io.*;

/*
转换流：实现从字节流到字符流 --本身是字符流
场景：要让字符缓冲流的readLine(), newLine()等服务于字节流
InputStreamReader:输入转换流
OutputStreamWriter：输出转换流
 */
public class Demo6 {
    public static void main(String[] args) throws IOException {
        //实现功能：实现从键盘接收数据，再将数据显示在控制台
        /*          要求使用readLine(),newLine()
        分析:是从键盘直接接收数据--System.in
             是将数据显示在控制台--System.out
              所以要先将字节流换成转换流，再通过转换流得到字符缓冲流
         */
        //获取字符缓冲流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        //读写
        String data = null;
        while ((data = bufferedReader.readLine())!=null){
            bufferedWriter.write(data);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            if(data.equals("over")){
                break;
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
