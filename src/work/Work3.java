package work;

import java.io.*;

/**
 * 3、编写应用程序，创建一个文件输出流，向文件中分别中分别写入一下类型数据:
 * int、double和字符串，然后创建一个文件输入流，将文件中写入的数据显示
 * 在屏幕上。
 */
public class Work3 {
    public static void main(String[] args) {
        FileOutputStream fOut = null;
        DataOutputStream dataOutput = null;
        DataInputStream dataInput = null;
        FileInputStream fin = null;
        try{
            fin = new FileInputStream("src//in.txt");
            fOut = new FileOutputStream("src//in.txt");
            dataOutput = new DataOutputStream(fOut);
            dataInput = new DataInputStream(fin);
            dataOutput.writeInt(4);
            dataOutput.writeDouble(4.5d);
            dataOutput.writeUTF("abcdef你好");

            System.out.println(dataInput.readInt());
            System.out.println(dataInput.readDouble());
            System.out.println(dataInput.readUTF());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fOut.close();
                fin.close();
                dataOutput.close();
                dataInput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
