package com;

import java.io.*;
import java.util.zip.*;

public class ZipInputOutputStream {
    File targetFile;
    ZipInputStream zin;

    public ZipInputOutputStream() {
    }

    public ZipInputOutputStream(File target) {
        targetFile = target;
        if (targetFile.exists())
            targetFile.delete();
    }

    /**
     * 压缩入口
     */
    void zip(File file, ZipOutputStream out, String baseDir) throws IOException {
        if (file.isDirectory()) {
            this.zipDir(file, out, baseDir);
        } else {
            this.zipFile(file, out, baseDir);
        }
    }

    /**
     * 压缩文件夹
     */
    void zipDir(File dir, ZipOutputStream out, String baseDir) throws IOException {
        if (!dir.exists()) {
            return;
        }
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            zip(files[i], out, baseDir + dir.getName() + "/");
        }
    }

    /**
     * 压缩文件
     */
    void zipFiles(File srcFile) throws Exception {
        ZipOutputStream out = null;
        try {
            out = new ZipOutputStream(new FileOutputStream(targetFile));

            if(srcFile.isFile()){

                zipFile(srcFile, out, "");
            } else{
                File[] list = srcFile.listFiles();
                for (int i = 0; i < list.length; i++) {
                    zip(list[i], out, "");
                }
            }

            System.out.println("压缩完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 压缩单个文件
     */
    void zipFile(File srcFile, ZipOutputStream out, String basedir) throws IOException {
        if (!srcFile.exists())
            return;

        byte[] buf = new byte[1024];
        FileInputStream in = null;

        try {
            int len;
            in = new FileInputStream(srcFile);
            out.putNextEntry(new ZipEntry(basedir + srcFile.getName()));

            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null)
                    out.closeEntry();
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 解压单个文件
     *
     * @param srcPath
     * @param desPath
     * @throws Exception
     */
    void freeZip(String srcPath, String desPath) throws Exception {
        File f = new File(srcPath);
        zin = new ZipInputStream(new BufferedInputStream(new FileInputStream(f)));
        ZipEntry zipfile = null;
        while ((zipfile = zin.getNextEntry()) != null) {
            String fileName = zipfile.getName();
            BufferedInputStream bin = new BufferedInputStream(zin);
            BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(desPath + fileName));
            int len = -1;
            byte[] bytes = new byte[1024];
            while ((len = bin.read(bytes)) != -1) {
                bout.write(bytes, 0, len);
            }
            bout.close();
        }
        zin.close();
    }

    public static void main(String[] args) throws Exception {
        File f = new File("E\\test");
        ZipInputOutputStream zOut = new ZipInputOutputStream(
                new File("E:\\t", f.getName() + ".zip"));
//        ZipOutputStream out = new ZipOutputStream();
//        File fin = new File("F:\\下载\\YYSetup-8.39.0.2-zh-CN.exe");
//        File fin2 = new File("F:\\test");
//        File[] files = {fin, fin2};
//        File[] files = {new File("E:\\test")};
//		zOut.zip(fin2,,"E:\\test\\test1Zip.zip");
//        zOut.freeZip("E:\\test\\testZip.zip", "E:\\test\\");

        zOut.zipFiles(f);
    }

}
