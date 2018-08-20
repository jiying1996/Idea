package com.day21;

/*
递归：定义：有条件的自己调用自己（方法）
条件1.要给一个出口负责结束当前的递归
    2.循环次数不能太多，否则占用内存太多导致死机
 死循环：1.自己调用自己（方法） 2.方法之间相互调用

 实例：求1-10之间的和
 */
public class Demo11 {
    public static void main(String[] args) {
        Person p = new Person();
        p.run();
        System.out.println(Person.sum);
    }
}

class Person {
    static int sum = 0;
    static int i = 1;

    public void run() {
        sum += i;
        if(i++ == 10) return;
        run();
//        if (++i <= 10) {
//            run();
//        }
    }
}