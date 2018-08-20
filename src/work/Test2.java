package work;

import java.io.File;

public class Test2 {
    public static void main(String[] args) {
        /*
        作业：遍历当前目录下所有的文件 -- 递归
         */
        listAllFiles("E:\\test");
    }

    public static void listAllFiles(String pathName) {
        File file = new File(pathName);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else {
                File[] files = file.listFiles();
                for (File file1 : files) {
                    if (file1.isDirectory()) {
                        listAllFiles(pathName + File.separator + file1.getName());
                    } else {
                        file1.delete();
                    }
                }
            }
        } else {
            System.out.println("目录不存在");
        }
    }
}
