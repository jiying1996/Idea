package com.day21;

import java.io.File;

public class Demo10 {
    public static void main(String[] args) {
        //获取根目录 -- 获取的是当前主机的所有根目录
        File[] files = File.listRoots();
        for (File f : files) {
            System.out
                    .println(f);
        }
        System.out.println("-----------------------");
        //获取当前目录下的文件或文件夹，不包括子目录 特点：这里只得到了文件夹或文件的名字，没有全路径
        File file = new File("E:\\Idea\\IODemo");
        String[] strings = file.list();
        for (String s : strings) {
            System.out.println(s);
        }
        System.out.println("-----------------------");
        //获取当前目录下的文件或文件夹的全路径
        File[] files2 = file.listFiles();
        for (File file2 : files2) {
            System.out.println("全路径-->" + file2);
        }

    }
}
