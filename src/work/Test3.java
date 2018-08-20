package work;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test3 {
    public static void main(String[] args) throws IOException {
        /*
        3.将当前的工程目录中后缀名为.txt的文件找出,并将内容添加到名字叫zong.txt的文件中,并将该文件重新放到工程目录/day21/zuoye/third/下面.
         */
        SearchAllFiles("E:\\idea\\IODemo", "E:\\Test");
    }

    public static void SearchAllFiles(String pathName,String desPath) throws IOException {
        File file = new File(pathName);
        File file2 = new File(desPath);
        if(!file2.exists()){
            file2.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(desPath+File.separator+"zong.txt");
        if (file.exists()) {
            if (file.isFile()) {
                if(file.getName().endsWith(".txt")){
                    fileOutputStream.write(file.getName().getBytes());
                }
            } else {
                File[] files = file.listFiles();
                for (File file1 : files) {
                    if (file1.isDirectory()) {
                        SearchAllFiles(pathName + File.separator + file1.getName(),desPath);
                    } else {
                        if(file.getName().endsWith(".txt")){
                            fileOutputStream.write(file.getName().getBytes());
                        }
                    }
                }
            }
        } else {
            System.out.println("目录不存在");
        }
    }
}
