package com.fc.service.impl;

import com.fc.dao.AtmDao;
import com.fc.service.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnnotationServiceImpl implements AtmService {
    @Autowired
    private AtmDao atmDao;

    public void setAtmDao(AtmDao atmDao) {
        this.atmDao = atmDao;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ
            ,propagation = Propagation.REQUIRED, readOnly = false)
    public void transfer(Integer from, Integer to, Long money) {
            atmDao.decreaseMoney(from,money);

            atmDao.increaseMoney(to,money);
    }
}
