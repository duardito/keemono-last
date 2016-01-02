package com.keemono.page;

import com.keemono.base.AbstractBaseITCase;
import com.keemono.base.AbstractTableValidatorBean;
import com.keemono.base.SimpleDatasetWithOperation;
import com.keemono.common.Constants;
import com.keemono.common.converter.request.page.PageContentBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by edu on 02/01/2016.
 */
public class BasicPageTest  extends AbstractBaseITCase {

    private static final String INIT_PAGE_DATASET = "dataset/page/basic-page.xml";
    private static final String EXPECTED_CREATED_PAGE_DATASET = "dataset/page/created-page-expected.xml";


    @Test
    public void createPage() throws Exception {

        String content = PageContentBuilder.aPage()
                .withName("pagina 1")
                .withLayout("3695b78b-7218-4e53-897b-51d29c250912")
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
        String[] user = { "id", "uuid"};
        String[] page = { "id", "uuid"};
        tablesBeans.add(new AbstractTableValidatorBean("layout", layout));
        tablesBeans.add(new AbstractTableValidatorBean("user", user));

        tablesBeans.add(new AbstractTableValidatorBean("page", page));

        return tablesBeans;
    }
}
