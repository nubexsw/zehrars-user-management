package com.zehra.realstate.usermanagement.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import jakarta.transaction.TransactionManager;
import jakarta.transaction.UserTransaction;
import org.hibernate.engine.transaction.jta.platform.internal.AtomikosJtaPlatform;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import java.util.Map;

//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        basePackages = "com.zehra.realstate.usermanagement.persistence.user",
//        entityManagerFactoryRef = "mysqlEntityManagerFactory",
//        transactionManagerRef = "mysqlTransactionManager"
//)
//@EnableConfigurationProperties(MySqlXAProperties.class)
public class MySqlXAConfig {
    @Bean(name = "mysqlXADataSource")
    //@ConfigurationProperties(prefix = "mysql.xa-datasource")
    public DataSource mysqlXADataSource() {
        MysqlXADataSource mysqlXA = new MysqlXADataSource();
        mysqlXA.setUrl("jdbc:mysql://localhost:3306/zehrars_db");
        mysqlXA.setUser("root");
        mysqlXA.setPassword("root");
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXA);
        xaDataSource.setUniqueResourceName("mysqlXA");
        xaDataSource.setMinPoolSize(5);
        xaDataSource.setMaxPoolSize(20);
        xaDataSource.setBorrowConnectionTimeout(60);
        xaDataSource.setTestQuery("SELECT 1");
        return xaDataSource;
    }

    @Bean(name = "mysqlXAEntityManager")
    public LocalContainerEntityManagerFactoryBean mysqlXAEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(mysqlXADataSource())
                .packages("com.zehra.realstate.usermanagement.persistence.user")
                .persistenceUnit("mysqlPU")
                .properties(Map.of(
                        "hibernate.transaction.jta.platform", AtomikosJtaPlatform.class.getName(),
                        //"javax.persistence.transactionType", "JTA",
                        "hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect",
                        "hibernate.hbm2ddl.auto", "update",
                        "hibernate.show_sql", "true",
                        "hibernate.format_sql", "true"
                ))
                .build();
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(UserTransaction userTransaction,
                                                         TransactionManager transactionManager) throws Throwable {
        return new JtaTransactionManager(userTransaction, transactionManager);
    }
}
