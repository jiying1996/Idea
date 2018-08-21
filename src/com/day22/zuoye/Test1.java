package com.day22.zuoye;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * 1.记录一个程序的使用次数，超过5次提示去注册
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        File file = new File("test1.properties");
        if (!file.exists() || file == null) {
            file.createNewFile();
            properties.setProperty("num", "0");
        }
        FileReader fileReader = new FileReader(file);
        properties.load(fileReader);

        try {
            int num = Integer.parseInt(properties.getProperty("num"));
        } catch (NumberFormatException e) {//num键不存在的时候，创建key-value
            properties.setProperty("num", "0");
        }

        int num = Integer.parseInt(properties.getProperty("num"));
        if (++num >= 5) {
            System.out.println("您使用的次数超过5次，请前去注册");
        }

        System.out.println("第" + num + "次使用");
        FileWriter fileWriter = new FileWriter(file);
        properties.setProperty("num", String.valueOf(num));
        properties.store(fileWriter, null);
        fileReader.close();
        fileWriter.close();
    }
}