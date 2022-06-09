package com.study.revise01;

import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /**
         * next()不能得到带有空格的字符。
         */
        System.out.println("使用next方式来接收");
        if (scanner.hasNext()){
            String string = scanner.next();
            System.out.println("输入的内容是："+string);
        }
        /**
         * nextLine()以回车作为结束，可以接受空白字符。
         */
        System.out.println("使用nextLine方式来接收");
        if (scanner.hasNextLine()){
            String string = scanner.nextLine();
            System.out.println("输入的内容是："+string);
        }
        /**
         * IO流使用后要关闭，节省资源。
         */
        scanner.close();
    }
}
