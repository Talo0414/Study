package com.study.revise05;

public class Demo05 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("线程中"+i);
            }
            System.out.println("__________");
        });
        //观察状态
        Thread.State state = thread.getState();
        //NEW
        System.out.println(state);
        //观察启动后
        thread.start();
        state = thread.getState();
        //RUNNABLE
        System.out.println(state);
        //只要线程不终止就，一直输出状态
        while(state != Thread.State.TERMINATED){
            Thread.sleep(100);
            state = thread.getState();
            System.out.println(state);
        }
    }
}
