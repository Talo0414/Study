package com.study.revise05;

//模拟取钱
public class Demo09 {
    public static void main(String[] args) {
        Account account = new Account(1000,"我的钱");
        Drawing me = new Drawing(account,50,"我");
        Drawing you = new Drawing(account,100,"你");
        me.start();
        you.start();
    }
}
//账户
class Account{
    //余额
    int money;
    //卡名
    String name;
    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}
//银行：模拟取款
class Drawing extends Thread{
    //账户
    Account account;
    //取的钱
    int drawingMoney;
    //手里的钱
    int nowMoney;
    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;

    }
    //取钱
    @Override
    public void run() {
        //synchronized块
        synchronized(account){
            //判断有没有钱
            if (account.money-drawingMoney<0){
                System.out.println(Thread.currentThread().getName()+"钱不够，取不了");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //卡内余额
            account.money = account.money - drawingMoney;
            //手里的钱
            nowMoney = nowMoney + drawingMoney;
            System.out.println(account.name+"余额为："+account.money);
            //Thread.currentThread().getName() = this.getName()
            //因为继承了Thread，所以可用Thread的所有方法
            System.out.println(this.getName()+"手里的钱"+nowMoney);
        }
    }
}
