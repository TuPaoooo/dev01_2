package com.fc.demo2._jdk;

public class GamePlayer implements GamePlay{
    @Override
    public void login() {
        System.out.println("圣亚，TIMI");
    }

    @Override
    public void killBoss() {
        System.out.println("圣亚，打怪");
    }

    @Override
    public void upgrade() {
        System.out.println("圣亚，升级");
    }
}
