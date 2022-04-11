package com.fc.service.impl;

import com.fc.dao.AtmDao;
import com.fc.service.AtmService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class ProgrammingServiceImpl implements AtmService {
   private AtmDao atmDao;

   //声明一个事务的模板
    private TransactionTemplate transactionTemplate;

    @Override
    public void transfer(Integer from, Integer to, Long money) {

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                atmDao.decreaseMoney(from,money);

                atmDao.increaseMoney(to,money);
            }
        });

    }

    public void setAtmDao(AtmDao atmDao) {
        this.atmDao = atmDao;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }
}
