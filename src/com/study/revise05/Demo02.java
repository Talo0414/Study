package com.study.revise05;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo02 {
    //打印系统当前时间
    public static void main(String[] args) {
        //获取系统当前时间
        Date startTime = new Date(System.currentTimeMillis());
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                //更新当前时间
                startTime = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
