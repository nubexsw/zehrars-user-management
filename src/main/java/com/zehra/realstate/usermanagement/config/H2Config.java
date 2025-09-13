package com.zehra.realstate.usermanagement.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.zehra.realstate.usermanagement.persistence.audit",
        entityManagerFactoryRef = "h2EntityManagerFactory",
        transactionManagerRef = "h2TransactionManager"
)
public class H2Config {

    @Bean
    @ConfigurationProperties(prefix = "h2.datasource")
    public DataSource h2DataSource() {
        // Configure and return the H2 DataSource
//        org.springframework.jdbc.datasource.DriverManagerDataSource dataSource = new org.springframework.jdbc.datasource.DriverManagerDataSource();
//        dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("");
//        return dataSource;
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean h2EntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(h2DataSource())
                .packages("com.zehra.realstate.usermanagement.persistence.audit")
                .persistenceUnit("h2")
                .properties(Map.of(
                        "hibernate.dialect", "org.hibernate.dialect.H2Dialect",
                        "hibernate.hbm2ddl.auto", "update",
                        "hibernate.show_sql", "true",
                        "hibernate.format_sql", "true"
                ))
                .build();
    }

    @Bean
    public PlatformTransactionManager h2TransactionManager(
            @Qualifier("h2EntityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
