package com.day21;

import java.io.File;

public class Demo13 {
    public static void main(String[] args) {
        /*
        作业：遍历当前目录下所有的文件 -- 递归
         */
        listAllFiles("E:\\Idea\\IODemo");
    }
    public static void listAllFiles(String pathName){
        File file = new File(pathName);
        if(file.exists()) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
            } else {
                File[] files = file.listFiles();
                for (File file1 : files) {
                    if (file1.isDirectory()) {
                        listAllFiles(pathName + File.separator + file1.getName());
                    }
                    System.out.println(file1.getAbsolutePath());
                }
            }
        }else {
            System.out.println("目录不存在");
        }
    }
}