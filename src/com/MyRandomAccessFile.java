package com;
import java.io.*;
public class MyRandomAccessFile {
    private RandomAccessFile rf;
    void writeData() throws Exception{
        rf = new RandomAccessFile("src//in.txt","rw");
        rf.writeBoolean(true);
        rf.writeByte(100);
        rf.writeChar('a');
        rf.writeDouble(4.5d);
        rf.writeUTF("中国");
        rf.close();
    }

    void readData() throws Exception {
        rf = new RandomAccessFile("src//in.txt","rw");
        System.out.println(rf.readBoolean());
        System.out.println(rf.readByte());
        System.out.println(rf.readChar());
        System.out.println(rf.readDouble());
        System.out.println(rf.readUTF());
        rf.close();
    }
    void randomRead() throws Exception{
        rf = new RandomAccessFile("src//in.txt","rw");
        rf.skipBytes(4);//相对文件指针
        System.out.println(rf.readDouble());
        rf.seek(2);
        System.out.println(rf.readChar());
        rf.close();
    }

    public static void main(String[] args) throws Exception {
        MyRandomAccessFile raf=new MyRandomAccessFile();
//            raf.writeData();
//		    raf.readData();
            raf.randomRead();
    }
}
