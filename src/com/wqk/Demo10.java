package com.wqk;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * LineNumberReader:是BufferedReader的子类，不能读，但是可以提高效率
 * 特有功能：可以设置行号，获取行号
 */
public class Demo10 {
    public static void main(String[] args) throws IOException {
        //1.创建缓冲流
        LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("temp5.txt"));
        //设置行号：默认从0开始设置 从设置的下一位(1)开始计数
        lineNumberReader.setLineNumber(0);

        String data = null;
        while ((data = lineNumberReader.readLine())!=null){
            System.out.print(lineNumberReader.getLineNumber());
            System.out.println(data);
        }
        lineNumberReader.close();
    }
}
