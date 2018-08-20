package com.wqk;

import java.io.*;

/**
 * 使用字符缓冲流实现文件的复制
 * 使用Demo8的内容复制到temp5.txt
 */

public class Demo9 {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("src/com/wqk/Demo8.java"));
            bufferedWriter = new BufferedWriter(new FileWriter("temp5.txt"));

//            char[] chars = new char[50];
//            int s;
//            while ((s = bufferedReader.read(chars)) != -1) {
//                bufferedWriter.write(chars, 0, s);
//            }
            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
