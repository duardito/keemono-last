package com.keemono.base;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.github.springtestdbunit.bean.DatabaseConfigBean;
import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean;
import com.keemono.web.WebConfiguration;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

/**
 * Created by edu on 17/10/2015.
 */
@Transactional
@DbUnitConfiguration(databaseConnection={"dataSource"})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@WebAppConfiguration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.keemono.web","com.keemono.common","com.keemono.service","com.keemono.integration"} )
@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfiguration.class})
public abstract class AbstractBaseITCase {

    @Bean
    public DatabaseConfigBean databaseConfigBean(){
        DatabaseConfigBean databaseConfigBean = new DatabaseConfigBean();
        databaseConfigBean.setCaseSensitiveTableNames(true);
        databaseConfigBean.setDatatypeFactory(new MySqlDataTypeFactory());
        return databaseConfigBean;
    }

    @Bean
    public DatabaseDataSourceConnectionFactoryBean databaseDataSourceConnectionFactoryBean(DataSource dataSource){
        DatabaseDataSourceConnectionFactoryBean ds = new DatabaseDataSourceConnectionFactoryBean();
        ds.setDataSource(dataSource);
        ds.setDatabaseConfig(databaseConfigBean());
        return ds;
    }

}
