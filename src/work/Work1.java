package work;

import java.io.*;
import java.util.Scanner;

/**
 * 1、编写应用程序，使用文件输入输出流实现文件的复制，
 * 被拷贝的源文件和复制目标文件由命令行参数给出
 */
public class Work1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要拷贝的源文件的路径");
        String srcPath = sc.next();

        System.out.println("请输入要拷贝的目标路径");
        String desPath = sc.next();

        FileInputStream fin = null;
        FileOutputStream fOut = null;
        try {
            fin = new FileInputStream(new File(srcPath));
            fOut = new FileOutputStream(new File(desPath));
            byte[] bytes = new byte[10];
            int len = -1;
            while ((len = fin.read(bytes))!=-1){
                fOut.write(bytes,0,len);
            }
            System.out.println("完成");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fOut.close();
                fin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
