package com.study.revise03;

public class Demo01 extends Thread{
    //创建线程的方法一：继承Thread类，重写run()方法，调用start开启线程
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("这是一个线程"+i);
        }
    }
    //主线程
    public static void main(String[] args) {
        //创建一个线程对象
        Demo01 demo01 = new Demo01();
        //调用start()方法开启线程
        demo01.start();
        for (int i = 0; i < 200; i++) {
            System.out.println("这是主线程"+i);
        }
    }
}
