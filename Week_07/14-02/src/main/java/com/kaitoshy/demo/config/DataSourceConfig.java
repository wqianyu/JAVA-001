package com.kaitoshy.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author kaito
 * @createDate 2020/12/3 23:39
 */
@Configuration
@Slf4j
public class DataSourceConfig {
    
    @Bean
    @ConfigurationProperties("master.datasource")
    public DataSourceProperties masterDataSourceProperties() {
        return new DataSourceProperties();
    }
    
    @Bean
    public DataSource masterDataSource() {
        DataSourceProperties dataSourceProperties = masterDataSourceProperties();
        log.info("master datasource: {}", dataSourceProperties.getUrl());
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }
    
    @Bean
    @Resource
    public PlatformTransactionManager masterTxManager(DataSource masterDataSource) {
        return new DataSourceTransactionManager(masterDataSource);
    }
    
    @Bean
    @Primary
    public JdbcTemplate masterJdbcTemplate(DataSource masterDataSource) {
        return new JdbcTemplate(masterDataSource);
    }
    
    
    @Bean
    @ConfigurationProperties("slave.datasource")
    public DataSourceProperties slaveDataSourceProperties() {
        return new DataSourceProperties();
    }
    
    @Bean
    public DataSource slaveDataSource() {
        DataSourceProperties dataSourceProperties = slaveDataSourceProperties();
        log.info("slave datasource: {}", dataSourceProperties.getUrl());
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }
    
    @Bean
    @Resource
    public PlatformTransactionManager barTxManager(DataSource slaveDataSource) {
        return new DataSourceTransactionManager(slaveDataSource);
    }
    
    @Bean(name = "slaveJdbcTemplate")
    public JdbcTemplate salveJdbcTemplate(DataSource slaveDataSource) {
        return new JdbcTemplate(slaveDataSource);
    }
}
