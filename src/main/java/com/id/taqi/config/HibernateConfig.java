package com.id.taqi.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration  
@EnableTransactionManagement  
@EnableAutoConfiguration(exclude = { HibernateJpaAutoConfiguration.class}) 
@ComponentScan(value = "com.id.taqi")
public class HibernateConfig {

	@Autowired
	private Environment env;
	
	@Bean  
    public DataSource dataSource() {  
        DriverManagerDataSource dataSource = new DriverManagerDataSource();  
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver"));  
        dataSource.setUrl(env.getProperty("spring.datasource.url"));  
        dataSource.setUsername(env.getProperty("spring.datasource.username"));  
        dataSource.setPassword(env.getProperty("spring.datasource.password"));  
        return dataSource;  
    }  
	
	@Bean  
    public LocalSessionFactoryBean sessionFactory() {  
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();  
        sessionFactory.setDataSource(dataSource());  
        sessionFactory.setPackagesToScan(env.getProperty("entitymanager.packagesToScan"));  
        Properties hibernateProperties = new Properties();  
        hibernateProperties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));  
        hibernateProperties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));  
        hibernateProperties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));  
        sessionFactory.setHibernateProperties(hibernateProperties);  
        return sessionFactory;  
    }  
	
	@Bean  
    public HibernateTransactionManager transactionManager() {  
        HibernateTransactionManager txManager = new HibernateTransactionManager();  
        txManager.setSessionFactory(sessionFactory().getObject());  
        return txManager;  
    }  
}
