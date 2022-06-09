package com.study.revise04;

public class Demo01 {
    //3.静态内部类
    static class lambdatest1 implements TestLambda{
        @Override
        public void lambda() {
            System.out.println("静态内部类");
        }
    }
    public static void main(String[] args) {
        TestLambda testLambda = new lambdatest();
        testLambda.lambda();
        testLambda = new lambdatest1();
        testLambda.lambda();
        //4.局部内部类
        class lambdatest2 implements TestLambda{
            @Override
            public void lambda() {
                System.out.println("局部内部类");
            }
        }
        testLambda = new lambdatest2();
        testLambda.lambda();
        //5.匿名内部类，没有类的名称，必须借助接口或父类
        testLambda = new TestLambda() {
            @Override
            public void lambda() {
                System.out.println("匿名内部类");
            }
        };
        testLambda.lambda();
        //6.用lambda简化
        testLambda = ()->{
            System.out.println("lambda简化");
        };
        testLambda.lambda();
    }

}
//1.定义一个函数式接口
interface TestLambda{
    void lambda();
}
//2.实现类
class lambdatest implements TestLambda{
    @Override
    public void lambda() {
        System.out.println("实现类");
    }
}
