package com.bytes.inputstream;

import javax.xml.crypto.Data;
import java.io.*;
import java.time.LocalDateTime;

/**
 * FileInputStream和FileOutputStream：对文件进行读写的流，效率较低
 *
 */
public class FileInAndOutputStream {
	/**
	 * 文件切割
	 * @param filename
	 */
	void fileSplit(String filename) throws Exception{

		FileInputStream fin = new FileInputStream(filename);

		int fileLength = fin.available();//获取文件长度
		int block = 3;//切割文件的片段数
		int splitLength = fileLength/block;//每段待读取的平均字节数

		byte[] block0 = new byte[splitLength];
		byte[] block1 = new byte[splitLength];
		byte[] block2 = new byte[fileLength-splitLength*2];

		fin.read(block0,0,splitLength);
//		fin.skip(splitLength);//文件相对指针
		fin.read(block1,0,splitLength);
//		fin.skip(splitLength);
		fin.read(block2,0,block2.length);
		fin.close();

		FileOutputStream fout0 = new FileOutputStream("e:\\t\\a0.tmp");
		fout0.write(block0);
		fout0.close();

		FileOutputStream fout1 = new FileOutputStream("e:\\t\\a1.tmp");
		fout1.write(block1);
		fout1.close();

		FileOutputStream fout2 = new FileOutputStream("e:\\t\\a2.tmp");
		fout2.write(block2);
		fout2.close();

	}
    public void merge(String srcName1,String srcName2,String srcName3 ,String desName) throws IOException {
        //      删除原来残存的目标文件
        File file = new File("e:\\t\\a.zip");
        file.delete();
        FileInputStream fiIn1 = new FileInputStream(srcName1);
        FileInputStream fiIn2 = new FileInputStream(srcName2);
        FileInputStream fiIn3 = new FileInputStream(srcName3);
        FileOutputStream fiOut1 = new FileOutputStream(desName,true);
        byte[] block4 = new byte[fiIn1.available()];
        byte[] block5 = new byte[fiIn2.available()];
        byte[] block6 = new byte[fiIn3.available()];
        fiIn1.read(block4);
        fiIn1.close();
        fiIn2.read(block5);
        fiIn2.close();
        fiIn3.read(block6);
        fiIn3.close();

        fiOut1.write(block4);
        fiOut1.write(block5);
        fiOut1.write(block6);
        fiOut1.close();
        System.out.println("文件复制完成");

        //删除中间生成的文件
        File f1 = new File(srcName1);
        File f2 = new File(srcName2);
        File f3 = new File(srcName3);
        f1.delete();
        f2.delete();
        f3.delete();
    }
    /**
     * 目录的拷贝(递归)
     * @param PathInput
     * @param PathOutput
     */
    public void isCopy(String PathInput, String PathOutput) {
        File inputFile = new File(PathInput);//使用局部变量
        File outputFile = new File(PathOutput);//使用局部变量
        if (inputFile.isDirectory()) {
            //每次进入一个新的源文件夹都在目标文件夹中建立相应的文件夹
            outputFile = new File(outputFile.getPath() + File.separator + inputFile.getName());
            outputFile.mkdirs();
            String[] fileArray = inputFile.list();

            for (int i = 0; i < fileArray.length; i++) {
                System.out.println("========>" + fileArray[i]);
            }

            for (int i = 0; i < fileArray.length; i++) {
                isCopy(inputFile.getPath() + File.separator + fileArray[i], outputFile.getPath());
            }
        } else {
            File tempOutputFile = new File(outputFile.getPath()
                    + File.separator + inputFile.getName());
            try {
                tempOutputFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            doCopy(inputFile, tempOutputFile);
            System.out.println("inputFile路径:" + inputFile.getPath());
            System.out.println("outputFile路径:" + outputFile.getPath());
        }
    }
        /**
         * 文件的拷贝
         * @param inputFile
         * @param outputFile
         * @throws Exception
         */
        public void doCopy(File inputFile, File outputFile) {
            try {
                int byteread = 0;
                InputStream inputStream = new FileInputStream(inputFile);
                FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
                byte[] buffer = new byte[1024];
                while ((byteread = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, byteread);
                }
                inputStream.close();
                fileOutputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public static void main(String[] args) throws Exception{
		FileInAndOutputStream f = new FileInAndOutputStream();
//        f.isCopy("E:\\test","E:\\t");//文件复制
        long start = System.currentTimeMillis();
        f.fileSplit("E:\\2018-6-12-15-48.zip");//文件分割
        f.merge("e:\\t\\a0.tmp","e:\\t\\a1.tmp","e:\\t\\a2.tmp","e:\\t\\a.zip");
        System.out.println(System.currentTimeMillis()-start);
	}
}