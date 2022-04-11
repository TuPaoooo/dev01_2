package com.fc.service;

public interface AtmService {
    //转账
    void transfer(Integer from,Integer to,Long money);
}
