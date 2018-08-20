package com;

import java.io.*;

public class MySequenceInputStream {
    public static void main(String[] args) throws IOException {
        BufferedOutputStream bOut = null;

        bOut = new BufferedOutputStream(new FileOutputStream("src//test.txt"));
        FileInputStream in1 = new FileInputStream("src//in.txt");
        FileInputStream in2 = new FileInputStream("src//out.txt");
        FileInputStream in3 = new FileInputStream("src//t1.txt");

        SequenceInputStream seq1 = new SequenceInputStream(in1,in2);
        SequenceInputStream seq2 = new SequenceInputStream(seq1,in3);

        int len;
        byte[] bytes = new byte[10];
        while ((len = seq2.read(bytes))!=-1){
            bOut.write(bytes,0,len);
        }
        bOut.close();
        in1.close();
        in2.close();
        in3.close();
        seq1.close();
        seq2.close();

    }
}
