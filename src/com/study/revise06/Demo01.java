package com.study.revise06;

import java.util.concurrent.locks.ReentrantLock;

public class Demo01 {
    public static void main(String[] args) {
        TestLock testLock = new TestLock();
        new Thread(testLock).start();
        new Thread(testLock).start();
        new Thread(testLock).start();
    }
}
class TestLock implements Runnable{
    int ticketNums = 10;
    //定义lock锁
    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try{
                //加锁
                lock.lock();
                if (ticketNums > 0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(ticketNums--);
                }else {
                    break;
                }
            }finally {
                //解锁
                lock.unlock();
            }

        }
    }
}