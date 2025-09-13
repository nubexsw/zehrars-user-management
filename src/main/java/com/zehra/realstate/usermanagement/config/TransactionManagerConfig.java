package com.zehra.realstate.usermanagement.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

//@Configuration
public class TransactionManagerConfig {

    // This ChainedTransactionManager is deprecated in Spring 6.0
//    @Bean(name = "chainedTxManager")
//    public PlatformTransactionManager transactionManager(
//            @Qualifier("mysqlTransactionManager") PlatformTransactionManager mysqlTxManager,
//            @Qualifier("h2TransactionManager") PlatformTransactionManager h2TxManager) {
//
//        return new ChainedTransactionManager(mysqlTxManager, h2TxManager);
//    }


}
