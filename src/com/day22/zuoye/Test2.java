package com.day22.zuoye;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 2.有五个学生，每个学生有3门课的成绩，
 * 从键盘输入以上数据（包括姓名，三门课成绩），
 * 输入的格式：如：zhagnsan，30，40，60计算出总成绩，
 * 并把学生的信息和计算出的总分数高低顺序存放在磁盘文件"stud.txt"中。
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        Student[] student = new Student[5];
        TreeSet<Student> treeSet = new TreeSet<>();
        for (int i = 0; i < 5; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入第" + i + 1 + "个学生的信息 如:zhagnsan,30,40,60");
            String[] str = scanner.nextLine().trim().split(",");
            int score1 = Integer.parseInt(str[1]);
            int score2 = Integer.parseInt(str[2]);
            int score3 = Integer.parseInt(str[3]);
            student[i] = new Student(str[0], score1, score2, score3);
            student[i].setWholeScore(score1 + score2 + score3);
            treeSet.add(student[i]);
        }
        File file = new File("stud.txt");
        if (file.exists()) {
            file.delete();
        }
        FileWriter fileWriter = new FileWriter(file, true);
        Iterator<Student> it = treeSet.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            fileWriter.write(s.toString() + "\t总分为：" + s.getWholeScore() + "\r\n");
        }
        System.out.println("存储完成");
        fileWriter.close();
    }
}

class Student implements Comparable<Student> {
    private String name;
    private int score1;
    private int score2;
    private int score3;

    public int getWholeScore() {
        return wholeScore;
    }

    public void setWholeScore(int wholeScore) {
        this.wholeScore = wholeScore;
    }

    private int wholeScore;

    public Student() {
    }

    public Student(String name, int score1, int score2, int score3) {
        this.name = name;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public int getScore3() {
        return score3;
    }

    public void setScore3(int score3) {
        this.score3 = score3;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score1=" + score1 +
                ", score2=" + score2 +
                ", score3=" + score3 +
                '}';
    }

    @Override
    public int compareTo(Student student) {
        return student.wholeScore - wholeScore;
    }
}