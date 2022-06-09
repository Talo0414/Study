package com.study.revise03;

//创建线程方法二：实现Runnable接口，重写run()方法，执行线程需要丢入runnable接口的实现类，调用start()方法
public class Demo02 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("这是一个线程"+i);
        }
    }

    public static void main(String[] args) {
        //创建runnable接口的实现类对象
        Demo02 demo02 = new Demo02();
        //创建线程对象，通过线程对象来开启我们的线程（代理）
//        Thread thread = new Thread(demo02);
//        thread.start();
//        以上两行代码可以简化为：
         new Thread(demo02).start();
        for (int i = 0; i < 200; i++) {
            System.out.println("这是主线程"+i);
        }
    }
}
