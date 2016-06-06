package com.keemono.controller.page;

import com.keemono.base.AbstractBaseITCase;
import com.keemono.base.AbstractTableValidatorBean;
import com.keemono.base.SimpleDatasetWithOperation;
import com.keemono.common.Constants;
import com.keemono.common.converter.request.page.PageContentBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by edu on 02/01/2016.
 */
@Ignore
public class BasicPageTest  extends AbstractBaseITCase {

    private static final String INIT_PAGE_DATASET = "dataset/page/basic-page.xml";
    private static final String EXPECTED_CREATED_PAGE_DATASET = "dataset/page/expected/created-page-expected.xml";

    @Test
    public void getAllPages() throws Exception {
        new SimpleDatasetWithOperation("dataset/page/basic-data-page.xml", DatabaseOperation.CLEAN_INSERT).executeOperation(databaseConnection);

        getMockMvc().perform(
                get(Constants._PAGE_URL+ Constants._LIST).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        assertDatasetWithNulls("dataset/page/expected/basic-data-page-expected.xml", generateBeanValidator());
    }

    @Test
    public void createPage() throws Exception {

        String content = PageContentBuilder.aPage()
                .withName("pagina 1")
                .withLayout("layout:3695b78b-7218-4e53-897b-51d29c250912")
                .withCreator("user:1695b78b-7218-4e53-897b-51d29c250965")
                .build();

        new  SimpleDatasetWithOperation(INIT_PAGE_DATASET, DatabaseOperation.CLEAN_INSERT).executeOperation(databaseConnection);
        getMockMvc().perform(
                post(Constants._PAGE_URL).contentType(MediaType.APPLICATION_JSON).content(content))
                .andExpect(status().isCreated()).andReturn();
        assertDatasetWithNulls(EXPECTED_CREATED_PAGE_DATASET, generateBeanValidator());
    }

    private List<AbstractTableValidatorBean> generateBeanValidator() {
        List<AbstractTableValidatorBean> tablesBeans = new ArrayList<AbstractTableValidatorBean>(0);

        String[] layout = { "id", "uuid"};
        String[] user = {"id", "uuid" , "lastPasswordReset", "authorities", "username" , "password"};
        String[] page = { "id", "uuid"};
        tablesBeans.add(new AbstractTableValidatorBean("layout", layout));
        tablesBeans.add(new AbstractTableValidatorBean("user", user));

        tablesBeans.add(new AbstractTableValidatorBean("page", page));

        return tablesBeans;
    }
}
