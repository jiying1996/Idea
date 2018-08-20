package com.day21;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/*
使用字节流读写图片
 */
public class Demo3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("page1.png");
        FileOutputStream fileOutputStream = new FileOutputStream("pageCopy.png");

        int num;
        byte[] bytes = new byte[1024];
        while ((num = fileInputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes,0, num);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
