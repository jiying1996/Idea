package com.wqk;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 *          装饰设计模式
 * 模拟字符缓冲读入流：BufferedReader
 * 分析:
 * 1.要属于流的体系
 * 2.要有一个Reader类型的成员变量
 * 3.要有一个带参数的构造方法接受外部传入的流对象
 * 4.模拟readLine()，实现读一行的功能
 * 5.关闭流
 */
public class Demo11 {
    public static void main(String[] args) throws IOException {
        MyBufferedReader myBufferedReader = new MyBufferedReader(new FileReader("temp5.txt"));
        String data = null;
        while ((data = myBufferedReader.myReadLine())!=null){
            System.out.println(data);
        }
        myBufferedReader.close();
    }
}

class MyBufferedReader extends Reader {//1.要属于流的体系
    //2.要有一个Reader类型的成员变量
    FileReader fileReader;

    //3.要有一个带参数的构造方法接受外部传入的流对象
    public MyBufferedReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    //4.模拟readLine()，实现读一行的功能
    /**
     * 不要参数
     *
     * @return String
     */
    public String myReadLine() throws IOException {
        //要准备一个临时的可变字符串，存储当前行的数据
        StringBuffer buffer = new StringBuffer();
        //开始使用reader的read()方法来读取字符
        int num = 0;
        while ((num = fileReader.read()) != -1) {
            if (num == '\r')
                continue;
            else if (num == '\n')
                return buffer.toString();
            else
                buffer.append((char) num);
        }
        //当文本没有内容的时候的处理
        if (buffer.length() == 0){
            return null;
        }
        //当文本只有一行的时候，没有使用换行符
        return buffer.toString();

        //这里有提高效率的功能，
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return 0;
    }

    @Override
    public void close() throws IOException {//5.关闭流
        //将流对象关闭
        //将自己关闭
        this.close();
        fileReader.close();
    }
}