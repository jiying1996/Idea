package work;

import java.io.*;
import java.util.Random;

public class Work4 {

    public static void main(String[] args) throws Exception {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream();

        pos.connect(pis); // 连接这两个管道

        Thread senderThread = new Thread(new SenderRunnable(pos));
        Thread receiverThread = new Thread(new ReceiverRunnable(pis));

        senderThread.start();
        receiverThread.start();
    }
}

class SenderRunnable implements Runnable {
    private final PipedOutputStream out;
    public SenderRunnable(PipedOutputStream out) {
        this.out = out;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            for (int i = 1, num; i <= 100; i++) {
                // 这个方法只能写 byte 类型的值，但是要求的整数范围是 10~20，所以可以满足
                num = 10 + random.nextInt(11);
                System.out.format("第 %d 次输出： %d%n", i, num);
                out.write(num); // 向管道写一个 10 ~ 20 整数（包含10,20）
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
}

class ReceiverRunnable implements Runnable {
    private final PipedInputStream in;
    public ReceiverRunnable(PipedInputStream in) {
        this.in = in;
    }
    @Override
    public void run() {
        try {
            for (int i = 1, num; i <= 100; i++) {
                num = in.read(); // 读取一个 byte
                System.out.format("第 %d 次读取： %d%n", i, num);
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }

}