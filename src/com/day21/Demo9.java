package com.day21;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/*
文件：File类 用来操作文件和路径（目录）

创建文件
创建路径
创建多路径

判断是否是文件
判断是否是路径
判断是否隐藏

获取根目录
获取指定目录下的文件或文件夹
 */
public class Demo9 {
    public static void main(String[] args) throws IOException {
        //1.创建File对象的三种方式
        //a:通过完整的路径实现
        File file1 = new File("E:\\Idea\\IODemo\\src\\com\\day21\\Demo8.java");
        //b:通过父目录子目录
        File file2 = new File("E:\\Idea\\IODemo\\src\\com\\day21","Demo8.java");
        //c:先得到父目录的File对象
        File file3 = new File("E:\\Idea\\IODemo\\src\\com\\day21");
        File file4 = new File(file3,"Demo8.java");

        //2.创建文件
        File file5 = new File("E:\\Idea\\IODemo\\temp5.txt");
        file5.createNewFile();

        //3.创建路径:注意：通过mkdir()或mkdirs()只能创建路径，不能创建文件
        File file6 = new File("E:\\Idea\\IODemo\\temp6.txt\\temp\\hello");
        //只能创建单层目录
//        file6.mkdir();
        //创建多层目录
        file6.mkdirs();

        //4.判断是否是文件
        System.out.println(file3.isFile());//路径false
        System.out.println(file5.isFile());//文件true

        //5.是否是路径
        System.out.println(file3.isDirectory());//路径true
        System.out.println(file5.isDirectory());//文件false

        //6.是否隐藏
        System.out.println(file1.isHidden());//false

        //7.获取文件的最后修改时间
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String dateTime=df.format(new Date(file1.lastModified()));
        System.out.println(dateTime);
//        System.out.println(file1.lastModified());
    }
}
