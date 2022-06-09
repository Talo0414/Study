package com.study.revise05;

public class Demo06 {
    //测试线程优先级
    public static void main(String[] args) {
        //主线程默认优先级
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
        MyPriority myPriority = new MyPriority();
        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        Thread t5 = new Thread(myPriority);
        Thread t6 = new Thread(myPriority);
        //默认
        t1.start();
        //最小
        t2.setPriority(Thread.MIN_PRIORITY);
        t2.start();
        //最大
        t3.setPriority(Thread.MAX_PRIORITY);
        t3.start();
        t4.setPriority(3);
        t4.start();
        t5.setPriority(8);
        t5.start();
        t6.setPriority(9);
        t6.start();
    }
}
class MyPriority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }
}
