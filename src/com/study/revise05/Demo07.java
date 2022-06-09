package com.study.revise05;

public class Demo07 {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();
        Thread thread = new Thread(god);
        //设置守护进程，默认值为false，表示用户线程
        thread.setDaemon(true);
        //上帝守护进程启动
        thread.start();
        //You用户进程启动
        new Thread(you).start();
    }
}
class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("上帝在守护着你");
        }
    }
}
class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 365; i++) {
            System.out.println("今天是第"+(i+1)+"天");
        }
        System.out.println("Goodbye,World!");
    }
}
