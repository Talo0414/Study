package com.study.revise04;

public class Demo03 implements Runnable{
    //1.设置一个标志位
    private boolean flag = true;
    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println("run...Thread"+i++);
        }
    }
    //2.设置一个公开的方法停止线程，转换标志位
    public void stopflag(){
        this.flag = false;
    }
    public static void main(String[] args) {
        Demo03 demo03 = new Demo03();
        new Thread(demo03).start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main"+i);
            if (i==90){
                //调用stopflag方法切换标志位
                demo03.stopflag();
                System.out.println("线程停止");
                break;
            }
        }
    }
}
