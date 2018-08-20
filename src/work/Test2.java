package work;

import java.io.File;

public class Test2 {
    public static void main(String[] args) {
        /*
        2.删除指定目录下的文件及文件夹，包括子目录中的内容(当前的工程目录)
         */
        deleteAllFiles("E:\\test");
    }

    public static void deleteAllFiles(String pathName) {
        File file = new File(pathName);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else {
                File[] files = file.listFiles();
                for (File file1 : files) {
                    if (file1.isDirectory()) {
                        deleteAllFiles(pathName + File.separator + file1.getName());
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
