package com.day21;

public class Demo12 {
    static int sum1 = 1;
    static int sum2 = 1;
    static int i = 1;

    public static void main(String[] args) {
        //递归实例一：求1-10之间所有偶数的积与奇数的积的差
        System.out.println(run());
//        run2();
//        System.out.println(sum1 - sum2);
    }

    public static int run() {
        if (i % 2 == 0) {
            sum1 *= i;
        } else if (i % 2 == 1) {
            sum2 *= i;
        }
        if (i++ == 10) {
            return sum1 - sum2;
        }
        int a = run();
        return a;
    }

//    public static void run2() {
//        if (i % 2 == 0) {
//            sum1 *= i;
//        } else if (i % 2 == 1) {
//            sum2 *= i;
//        }
//        if (i < 10) {
//            run2();
//        } else {
//            return;
//        }
//        return;
//    }
}
