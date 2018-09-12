package work;

import java.io.*;
/**
 * 编写应用程序，使用文件输入输出流对某个mp3文件的数据进行修改，并保存为新的mp3
 */
public class Work2 {
    public static void main(String[] args) {
        FileInputStream fin = null;
        FileOutputStream fOut = null;
        try {
            fin = new FileInputStream(new File("D:\\CloudMusic\\不才 - 参商(纯歌版).mp3"));
            fOut = new FileOutputStream(new File("D:\\CloudMusic\\(修改)不才 - 参商(纯歌版).mp3"));
            byte[] bytes = new byte[10];
            int len = -1;
            while ((len = fin.read(bytes)) != -1) {
                fOut.write(bytes, 0, len);
            }
            fOut.write(12);
            fOut.write(92);
            fOut.write(75);
            fOut.write(81);
            System.out.println("完成");

            fOut.close();
            fin.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
