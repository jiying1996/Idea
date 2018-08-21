package com.day21.zuoye;

import java.io.*;

public class Test3 {
    public static void main(String[] args) throws IOException {
        /*
        3.将当前的工程目录中后缀名为.txt的文件找出,并将内容添加到名字叫zong.txt的文件中,并将该文件重新放到工程目录/day21/zuoye/third/下面.
         */
        SearchAllFiles("E:\\Idea\\IODemo", "E:\\Test");
    }

    public static void SearchAllFiles(String pathName,String desPath) throws IOException {
        File file = new File(pathName);
        File file2 = new File(desPath);
        if(!file2.exists()){
            file2.mkdirs();
        }
        FileWriter fileWriter = new FileWriter(desPath+File.separator+"zong.txt",true);
        FileReader fileReader = null;
        if (file.exists()) {
            if (file.isFile()) {
                if(file.getName().trim().endsWith(".txt")){
                    fileReader = new FileReader(file);
                    char[] chars = new char[1024];
                    int len;
                    while ((len = fileReader.read(chars))!=-1){
                        fileWriter.write(chars,0,len);
                    }
                    fileReader.close();
                }
            } else {
                File[] files = file.listFiles();
                for (File file1 : files) {
                    if (file1.isDirectory()) {
                        SearchAllFiles(file1.getName(),desPath);
                    } else {
                        if(file1.getName().trim().endsWith(".txt")){
                            fileReader = new FileReader(file1);
                            char[] chars = new char[1024];
                            int len;
                            while ((len = fileReader.read(chars))!=-1){
                                fileWriter.write(chars,0,len);
                            }
                            fileReader.close();
                        }
                    }
                }
            }
        }
        fileWriter.close();
    }
}
