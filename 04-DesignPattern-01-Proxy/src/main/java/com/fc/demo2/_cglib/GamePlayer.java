package com.fc.demo2._cglib;

import com.fc.demo2._jdk.GamePlay;

public class GamePlayer implements GamePlay {
    @Override
    public void login() {
        System.out.println("ty timi");
    }

    @Override
    public void killBoss() {
        System.out.println("ty 打怪");
    }

    @Override
    public void upgrade() {
        System.out.println("ty,升级");
    }
}
