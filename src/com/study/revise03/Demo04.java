package com.study.revise03;

//静态代理模式(staticproxy)
public class Demo04 {
    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }
}
//定义一个结婚接口
interface Marry{
    void HappyMarry();
}
//真实对象
class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("yyh要嫁给djw了，哈哈哈");
    }
}
class WeddingCompany implements Marry{
    private Marry target;
    public WeddingCompany(Marry target){
        this.target = target;
    }
    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void before() {
        System.out.println("结婚之前，布置现场");
    }
    private void after() {
        System.out.println("结婚之后，收钱");
    }
}

