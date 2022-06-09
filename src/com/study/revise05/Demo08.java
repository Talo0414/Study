package com.study.revise05;

//模拟买票
public class Demo08 {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station,"黄牛").start();
        new Thread(station,"小明").start();
        new Thread(station,"小红").start();
    }
}
class BuyTicket implements Runnable{
    //票
    private int ticketNums = 10;
    //外部停止标签
    boolean flag = true;
    @Override
    public void run() {
        //买票
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //synchronized 同步方法，锁的是this
    private synchronized void buy() throws InterruptedException {
        if (ticketNums <= 0){
            flag = false;
            return;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNums--);
    }
}