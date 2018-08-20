package com;

import java.io.*;

public class MyFileReaderWriter {
    public void readFile(){
         try {
            FileReader fR = new FileReader("src//in.txt");
            char[] chars = new char[25];
            fR.read(chars);
            System.out.println(chars);
//            int len = -1;
//            while ((len = fR.read(chars))!=-1){
//                fR.read(chars,0,len);
//                System.out.print(chars);
//            }
            fR.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void writerFile(){
        try {
            FileWriter fW = new FileWriter("src//out.txt");
            fW.write("你好啊我是123");
            fW.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyFileReaderWriter myF = new MyFileReaderWriter();
        myF.readFile();
//        myF.writerFile();
    }
}
