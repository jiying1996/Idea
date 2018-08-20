package com.wqk;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo8 {
    public static void main(String[] args) {
       /*
       字符缓冲读入流：BufferedReader
        */
        //创建字符读入流
        //创建字符缓冲读入流。
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("temp4.txt"));
            //开始读操作
            //a:一次读一个字符
            int num;
//            while ((num = bufferedReader.read()) != -1) {
//                System.out.print((char) num);
//            }
            //b:一次读多个字符
//            char[] arr = new char[2];
//            while ((num = bufferedReader.read(arr)) != -1) {
//                System.out.print(new String(arr,0,num));
//            }

            //c:一次读一行 readLine()
            //原理：一个字符一个字符的读，直到读到换行符为止，然后将所有读到的字符返回
            //注意点：不会将当前的换行符返回，返回值就是我们读到的内容，如果读完了，返回null
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}