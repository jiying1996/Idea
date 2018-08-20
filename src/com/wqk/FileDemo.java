package com.wqk;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * File类的使用
 */
public class FileDemo {
    public static void main(String[] args) {
        //File类表示一个文件或目录
        //"E:\\test\\123.txt"
        File f1 = new File("E:"+File.separator+"test"+File.separator+"123.txt");
        if(!f1.exists()){
            try {
                f1.createNewFile();//创建文件
                System.out.println("文件创建成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(f1+"是否为文件夹:"+f1.isDirectory());
//        f1.delete();
        File f2 = new File("E:\\test\\my");
        boolean b = f2.delete();
        System.out.println(b);

        String[] names = f2.list();
        System.out.println(Arrays.toString(names));
    }
}
