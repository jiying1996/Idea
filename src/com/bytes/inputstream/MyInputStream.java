package com.bytes.inputstream;

import java.io.*;
import java.util.Scanner;

public class MyInputStream {
    static InputStream in ;
    static void readMethod() throws IOException {
        int i;
        byte[] b = new byte[23];
        in = new FileInputStream("src//in.txt");
//        in.read(b);
//            System.out.println(new String(b));
        in.close();
    }
    static void readMethod2() throws IOException {
        int i;
        in = new FileInputStream("src//in.txt");
        OutputStream out = new FileOutputStream("src//out.txt");
        while ((i = in.read())!=-1){
            out.write(i);
        }
        out.close();
        in.close();
    }
    static void readMethod3() throws IOException {
        in = new FileInputStream(new File("src//in.txt"));
        Scanner sc = new Scanner(in);
        System.out.println(in.available());
        String str = null;
        while (sc.hasNext()){
            System.out.print(sc.next());
        }

        sc.close();
        in.close();
    }

    public static void main(String[] args) throws IOException {
//        readMethod();
//        readMethod2();
        readMethod3();

    }
}
