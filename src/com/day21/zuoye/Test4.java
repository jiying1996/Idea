package com.day21.zuoye;

import java.io.*;
import java.util.Scanner;

/*
编写一个文件管理系统，通过控制台的输出内容进行文件操作：1 -创建文件、2-删除文件、3-复制文件和4-根据输入文件名称读取文件内容执行对应的指令。，
当用户输入1时，会读取用户的下一行输入，会根据用户的名称和后续输入创建一个文件并将输入录入文件；
当用户输入2，则会检索当前目录下的文件，如果文件存在，则删除该文件，否则，提示文件不存在；
当用户输入3，则读取用户输入的文件名称进行复制，默认是文件名称加后缀“.copy“标注；
当用户输入4，会查找当前目录下的文件，如果文件存在，则执行文件的行内容；
当用户输入“exit”并在后续 输入“Y”则退出当前系统
实现思路
     （1）首先需要读取控制台的输入内容，获取用户想要处理的下一个操作内容
     （2）根据输入的指令和输入内容，进行对应的操作，例如文件创建，创建的文件名称、文件内容等。
     （3）当输入指定4时，需要读取文件内容，判断文件内容是否符合要求，如果内容复合要求，则循环执行文件内容。
 */
public class Test4 {
    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("1-创建文件\t2-删除文件\t3-复制文件\t4-根据输入文件名称，读取文件内容执行对应的指令。\t输入exit则为退出");
            System.out.println("请输入1-4选择要操作的功能：");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.next();
            if (s.equals("exit")) {
                System.out.println("确定要退出？输入Y or N");
                if (scanner.next().equalsIgnoreCase("y"))
                    break;
                else
                    continue;
            }
            switch (s.trim()) {
                case "1":
                    makeFile();
                    break;
                case "2":
                    deleteFiles();
                    break;
                case "3":
                    copyFile();
                    break;
                case "4":
                    execute();
                    break;
                default:
                    System.out.println("你输入的指令有误，请重新输入！");
                    break;
            }
        }
    }

    /**
     * 功能一:创建文件
     *
     * @throws IOException
     */
    public static void makeFile() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要创建的文件名");
        String str = scanner.nextLine();
        File file = new File(str);
        System.out.println("请输入要存储的内容");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        String data = bufferedReader.readLine();
        bufferedWriter.write(data);
        bufferedWriter.close();
        bufferedReader.close();
        System.out.println("文件存储完成！");
    }

    /**
     * 删除指定文件
     */
    public static void deleteFiles() {
        System.out.println("请输入要删除文件的路径：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        File file = new File(str);
        if (file.isFile()) {
            if (file.exists()) {
                file.delete();
                System.out.println("删除成功");
            } else
                System.out.println("文件不存在");
        } else {
            System.out.println("输入的不是文件路径");
        }
    }

    /**
     * 复制文件
     *
     * @throws IOException
     */
    public static void copyFile() throws IOException {
        System.out.println("请输入要复制文件的路径：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        File file = new File(str);
        if (file.exists()) {
            FileReader fileReader = new FileReader(file);
            FileWriter fileWriter = new FileWriter(file + ".copy.txt");
            char[] chars = new char[1024];
            int len;
            while ((len = fileReader.read(chars)) != -1) {
                fileWriter.write(chars, 0, len);
            }
            fileReader.close();
            fileWriter.close();
            System.out.println("文件复制成功");
        } else
            System.out.println("文件不存在");
    }

    public static void execute() throws IOException {
        while (true) {
            System.out.println("请输入要查找以及执行的路径:");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            File file = new File(str);
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                int i = 1;
                for (File f : files) {
                    if (f == null) {
                        System.out.println("未找到可读文件");
                    } else {
                        if (f.isFile()) {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("找到第" + i++ + "个文件，正在读取中\n文件名为：" + f.getName() + "\n内容如下：");
                            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
                            String data = null;
                            while ((data = bufferedReader.readLine()) != null) {
                                System.out.println(data);
                            }
                        }
                    }
                }
                break;
            } else {
                System.out.print("您输入的路径不正确,");
                continue;
            }
        }
    }
}
