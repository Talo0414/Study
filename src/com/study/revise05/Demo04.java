package com.study.revise05;

//测试join方法
public class Demo04 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程VIP来了"+i);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        //启动线程
        Demo04 demo04 = new Demo04();
        Thread thread = new Thread(demo04);
        thread.start();
        //主线程
        for (int i = 0; i < 100; i++) {
            if (i == 20){
                thread.join();
            }
            System.out.println("主线程"+i);
        }
    }
}
