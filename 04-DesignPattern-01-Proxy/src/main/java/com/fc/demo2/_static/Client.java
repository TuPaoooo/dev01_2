package com.fc.demo2._static;

import org.junit.Test;

public class Client {
    @Test
    public void test(){
        GamePlayer gamePlayer = new GamePlayer();

        GamePlayProxy gamePlayProxy = new GamePlayProxy(gamePlayer);

        gamePlayProxy.login();
        gamePlayProxy.killBoss();
        gamePlayProxy.upgrade();
    }
}
