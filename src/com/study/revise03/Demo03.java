package com.study.revise03;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//线程创建方式三：实现callable接口
/*
    1.实现Callable接口，需要返回值类型
    2.重写call方法，需要抛出异常
    3.创建目标对象
    4.创建执行服务：ExecutorService ser = Executors.newFixedThreadPool(1);
    5.提交执行：Future<Boolean> result1 = ser.submit(t1);
    6.获取结果：boolean r1 = result1.get();
    7.关闭服务：ser.shutdownNow();
 */
public class Demo03 implements Callable<Boolean> {
    //重写call()方法
    @Override
    public Boolean call() throws Exception {
        System.out.println("线程线程");
        return true;
    }

    public static void main(String[] args) throws Exception{
        Demo03 d1 = new Demo03();
        Demo03 d2 = new Demo03();
        //创建执行服务（后面的数字代表多少个线程）
        ExecutorService service = Executors.newFixedThreadPool(2);
        //提交执行
        Future<Boolean> r1 = service.submit(d1);
        Future<Boolean> r2 = service.submit(d2);
        //获取结果
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        //关闭服务
        service.shutdownNow();
    }
}
