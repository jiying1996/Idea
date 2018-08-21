package com.day22;

import java.io.*;

/*
序列化流：是将短期存储的数据实现长期存储
数据的存储分为两类：
1.短期存储：存放在内存中，随着程序的关闭而释放--对象，集合，变量，数组。
2.长期存储：存储在磁盘中，即使程序关闭了，数据仍然存在----文件

序列化：将数据从内存放入磁盘，可以实现数据的长久保存--数据持久化的手段
反序列化：将数据从磁盘放回内存

进行序列化的步骤：--通过对象的序列化讲解
1.创建一个类
2.使用对应的流将对象存入磁盘中---序列化----ObjectOutputStream
3.使用对应的流将对象从磁盘中取出放回内存--反序列化----ObjectInputStream
4.关闭流
注意点：序列化流在工作时也要关联对应的输入流和输出流
 */
//类通过实现接口以启用其序列化功能，未实现此接口的类将无法使其任何状态序列化或反序列化
//可序列化类的所有子类型本身都是可序列化的，序列化接口没有方法或字段，仅用于标识可序列化的语义
class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class Demo6 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //写出--序列化
//        writeFile();
        //读入--反序列化
        readFile();
    }
    //写出--序列化
    public static void writeFile() throws IOException {
        //创建序列化流并关联文件
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("temp4.txt"));
        //调用方法实现序列化
        //序列化后的内容不能直接查看，要想查看进行反序列化
        objectOutputStream.writeObject(new Person("小明",22));
        objectOutputStream.close();
    }
    //读入--反序列化
    public static void readFile() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("temp4.txt"));
        //实现反序列化
        Object object = objectInputStream.readObject();

        //向下转型
        Person person = (Person)object;
        System.out.println(person);
    }
}
