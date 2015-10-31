package com.keemono.base;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.github.springtestdbunit.bean.DatabaseConfigBean;
import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean;
import com.keemono.web.WebConfiguration;
import org.dbunit.Assertion;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.ext.mysql.MySqlMetadataHandler;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by edu on 17/10/2015.
 */
//@Transactional
//@DbUnitConfiguration(databaseConnection={"dataSource"})
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
@DbUnitConfiguration(dataSetLoader = ColumnSensingFlatXMLDataSetLoader.class)
public abstract class AbstractBaseITCase {

    public static final String REPLACEMENT_FLAG_NULL = "[null]";

    protected MockMvc mockMvc;

    @Autowired
    private DataSource datasource;

    protected IDatabaseConnection databaseConnection;

    protected IDatabaseConnection getDatabaseConnection() {
        return databaseConnection;
    }

    public void setDatabaseConnection(IDatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Bean
    public DataSourceDatabaseTester databaseTester(DataSource dataSource){
        return  new DataSourceDatabaseTester(dataSource);
    }


    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() throws Exception {

        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

       databaseConnection = new DatabaseConnection(datasource.getConnection());

    }

    public MockMvc getMockMvc() {
        return mockMvc;
    }

    @Bean
    public DatabaseConfigBean databaseConfigBean(){
        DatabaseConfigBean databaseConfigBean = new DatabaseConfigBean();
        databaseConfigBean.setCaseSensitiveTableNames(false);
        databaseConfigBean.setMetadataHandler(new MySqlMetadataHandler());
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

    protected void assertDataset(String datasetToAssertPath, List<AbstractTableValidatorBean> tablesToValidate) throws Exception {

        ITable expectedTable, actualTable;
        IDataSet databaseDataSet;

        IDataSet expds = new FlatXmlDataSetBuilder().build(getClass().getClassLoader().getResourceAsStream(datasetToAssertPath));
        for (AbstractTableValidatorBean table : tablesToValidate) {

            expectedTable = expds.getTable(table.getTableName());
            databaseDataSet = databaseConnection.createDataSet();
            actualTable = databaseDataSet.getTable(table.getTableName());
            Assertion.assertEqualsIgnoreCols(expectedTable, actualTable, table.getColumnsToIgnore());
        }
    }

    protected void assertDatasetWithNulls(String expectedDatasetPath, List<AbstractTableValidatorBean> currentTables) throws Exception {
        ReplacementDatasetWithOperation expectedDataset = new ReplacementDatasetWithOperation(expectedDatasetPath, DatabaseOperation.NONE,
                REPLACEMENT_FLAG_NULL, null);

        ReplacementDataSet expds = (ReplacementDataSet) expectedDataset.getDataset();
        for (AbstractTableValidatorBean table : currentTables) {
            IDataSet databaseDataSet = this.databaseConnection.createDataSet();
            ITable currentTable = databaseDataSet.getTable(table.getTableName());

            ITable expectedTable = expds.getTable(table.getTableName());
            Assertion.assertEqualsIgnoreCols(expectedTable, currentTable, table.getColumnsToIgnore());
        }
    }

}
