
import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class MyFiles {
    public static void main(String[] args) {
//        Path p1 = Paths.get("E:\\","2018-6-12-15-48.zip");
//        Path p2 = Paths.get("E:\\T\\","2018-6-12-15-48.zip");
//        try {
//            Files.copy(p1,p2, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            FileChannel ar = new RandomAccessFile("E:\\S03E02.mp4", "rw").getChannel();
            FileChannel aw = new RandomAccessFile("E:\\test\\tes.mp4", "rw").getChannel();
            MappedByteBuffer mapBuffer = ar.map(FileChannel.MapMode.READ_WRITE, 0, ar.size());
//            ar.read(mapBuffer);
//            mapBuffer.flip();
            aw.write(mapBuffer);

            mapBuffer.clear();
            aw.close();
            ar.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
