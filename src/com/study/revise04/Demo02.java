package com.study.revise04;

public class Demo02 {
    public static void main(String[] args) {
        ILove love = null;
//        1.lambda表示简化
//        ILove love = (int a)->{
//            System.out.println("我爱你"+a);
//        };
//        简化1.参数类型（多个参数也可以去掉参数类型，但是要都去掉）
//        love = (a)->{
//            System.out.println("我爱你"+a);
//        };
//        简化2.简化括号
//        love = a -> {
//            System.out.println("我爱你"+a);
//        };
//        简化3.去掉花括号(当只有一行代码的时候才可以简化为一行，如果有多行，那么就用代码块)
        love = a -> System.out.println("我爱你"+a);
        love.love(5201314);
    }
}
interface ILove{
    void love(int a);
}