package com.keemono.configuration.mysql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by edu on 01/05/2015.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.keemono.domain.mysql")
@ComponentScan(basePackages = { "com.keemono.domain.mysql" })
@EnableTransactionManagement
public class PersistenceContext {
    private static final String PROPERTY_NAME_DATABASE_DRIVER = "dataSourceClassName";
    private static final String PROPERTY_NAME_DATABASE_URL = "dataSource.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "dataSource.user";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "dataSource.password";
    private static final String PROPERTY_NAME_DATABASE_CONNECTION_TEST_QUERY = "dataSource.connectionTestQuery";
    private static final String PROPERTY_NAME_DATABASE_CACHE_PREP_STMTS = "dataSource.cachePrepStmts";
    private static final String PROPERTY_NAME_DATABASE_PREP_STMT_CACHE_SIZE = "dataSource.prepStmtCacheSize";
    private static final String PROPERTY_NAME_DATABASE_PREP_STMT_CACHE_SQL_LIMIT = "dataSource.prepStmtCacheSqlLimit";

    // Hibernate constant properties
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    private static final String PROPERTY_NAME_HIBERNATE_EJB_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";

    @Bean(destroyMethod = "close")
    public DataSource dataSource(Environment env) {
        Properties props = new Properties();
        props.setProperty(PROPERTY_NAME_DATABASE_DRIVER, env.getProperty(PROPERTY_NAME_DATABASE_DRIVER));
        props.setProperty(PROPERTY_NAME_DATABASE_URL, env.getProperty(PROPERTY_NAME_DATABASE_URL));
        props.setProperty(PROPERTY_NAME_DATABASE_USERNAME, env.getProperty(PROPERTY_NAME_DATABASE_USERNAME));
        props.setProperty(PROPERTY_NAME_DATABASE_PASSWORD, env.getProperty(PROPERTY_NAME_DATABASE_PASSWORD));
        if (env.containsProperty(PROPERTY_NAME_DATABASE_CACHE_PREP_STMTS)) {
            props.setProperty(PROPERTY_NAME_DATABASE_CACHE_PREP_STMTS, env.getProperty(PROPERTY_NAME_DATABASE_CACHE_PREP_STMTS));
        }
        if (env.containsProperty(PROPERTY_NAME_DATABASE_PREP_STMT_CACHE_SIZE)) {
            props.setProperty(PROPERTY_NAME_DATABASE_PREP_STMT_CACHE_SIZE, env.getProperty(PROPERTY_NAME_DATABASE_PREP_STMT_CACHE_SIZE));
        }
        if (env.containsProperty(PROPERTY_NAME_DATABASE_PREP_STMT_CACHE_SQL_LIMIT)) {
            props.setProperty(PROPERTY_NAME_DATABASE_PREP_STMT_CACHE_SQL_LIMIT, env.getProperty(PROPERTY_NAME_DATABASE_PREP_STMT_CACHE_SQL_LIMIT));
        }

        HikariConfig config = new HikariConfig(props);
        if (env.containsProperty(PROPERTY_NAME_DATABASE_CONNECTION_TEST_QUERY)) {
            config.setConnectionTestQuery(env.getProperty(PROPERTY_NAME_DATABASE_CONNECTION_TEST_QUERY));
        }

        return new HikariDataSource(config);
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Environment env) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.keemono.domain");

        Properties jpaProperties = new Properties();
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_EJB_NAMING_STRATEGY, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_EJB_NAMING_STRATEGY));
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));

        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }

    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    /*
     * Use this post processor to translate any JAP Exception thrown in @Repository annotated classes
     */
    public @Bean
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
