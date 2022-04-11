package com.fc.demo1._jdk;
//当事人，原告（被代理对象，真实对象）
public class Parties implements Lawsuit {

    @Override
    public void submit() {
        System.out.println("老板欠薪跑路了");
    }

    @Override
    public void defend() {
        System.out.println("还我钱！！！");
    }
}
