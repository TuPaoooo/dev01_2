package com.fc.service.impl;

import com.fc.dao.AtmDao;
import com.fc.service.AtmService;

public class StatementServiceImpl  implements AtmService {
    private AtmDao atmDao;

    public void setAtmDao(AtmDao atmDao) {
        this.atmDao = atmDao;
    }

    @Override
    public void transfer(Integer from, Integer to, Long money) {
        atmDao.decreaseMoney(from,money);

        atmDao.increaseMoney(to,money);
    }

}
