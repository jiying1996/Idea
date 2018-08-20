import java.io.File;
import java.io.IOException;

public class FileOption {

    void createFileDir(String dirName) {
        boolean success;
        File f = new File(dirName);

        if (!f.exists()) {
            success = f.mkdir();
            if (success) {
                System.out.println("创建成功");
            }
        }else System.out.println("目录已存在");
    }

    public static void main(String[] args) {
        FileOption file = new FileOption();
//        file.createFileDir("E:\\test\\hello");
        File f = new File("E:\\test\\hello\\123.txt");
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
