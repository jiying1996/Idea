package com.day21;

import java.io.*;

/*
使用字节流读写图片
 */
public class Demo4 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("page1.png");
        FileOutputStream fileOutputStream = new FileOutputStream("pageCopy2.png");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        int num;
        byte[] bytes = new byte[1024];
        while ((num = bufferedInputStream.read(bytes))!=-1){
            bufferedOutputStream.write(bytes,0, num);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
