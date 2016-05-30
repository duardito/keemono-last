package com.keemono;

import com.keemono.core.mysql.configuration.MysqlConfiguration;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by edu on 23/05/2015.
 */
@EnableTransactionManagement
@Import(MysqlConfiguration.class)
@Configuration
public class SessionFactoryContext {

    @Autowired
    private Environment env;

    private static final String PROPERTY_NAME_DATABASE_DRIVER = "mysql.driver";
    private static final String PROPERTY_NAME_DATABASE_URL = "dataSource.url";
    private static final String PROPERTY_NAME_DATABASE_URN = "dataSource.user";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "dataSource.password";

    @Bean
    @Qualifier(value = "entityManager")
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

    @Bean(destroyMethod = "close")
    public DataSource dataSource() throws Exception {

        final ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass( env.getProperty(PROPERTY_NAME_DATABASE_DRIVER) );
        dataSource.setJdbcUrl(env.getProperty(PROPERTY_NAME_DATABASE_URL) );
        dataSource.setUser( env.getProperty(PROPERTY_NAME_DATABASE_URN));
        dataSource.setPassword( env.getProperty(PROPERTY_NAME_DATABASE_PASSWORD) );
        dataSource.setAutoCommitOnClose(false);
        dataSource.setInitialPoolSize(5);

        return dataSource;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource( dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.keemono.core.mysql");

        Properties jpaProperties = new Properties();
        //jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        //jpaProperties.setProperty("hibernate.naming-strategy","org.hibernate.cfg.DefaultNamingStrategy");
        //entityManagerFactoryBean.setJpaProperties(jpaProperties);
        entityManagerFactoryBean.afterPropertiesSet();
        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) throws Exception {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        transactionManager.setDataSource(dataSource());
        transactionManager.afterPropertiesSet();
        return transactionManager;
    }


}
