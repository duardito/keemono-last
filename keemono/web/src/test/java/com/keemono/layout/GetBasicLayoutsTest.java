package com.keemono.layout;

import com.keemono.base.AbstractBaseITCase;
import com.keemono.base.AbstractTableValidatorBean;
import com.keemono.base.SimpleDatasetWithOperation;
import com.keemono.common.Constants;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by edu on 17/10/2015.
 */
public class GetBasicLayoutsTest extends AbstractBaseITCase {

    private static final String EXPECTED_CREATED_LAYOUT_DATASET = "dataset/layout/created-layout-expected.xml";
    private static final String INIT_LAYOUT_DATASET = "dataset/layout/basic-layout.xml";
    private static final String INIT_LAYOUT_EXPECTED_DATASET = "dataset/layout/basic-layout-expected.xml";


    @Test
    public void getAllLayouts() throws Exception {

        new SimpleDatasetWithOperation(INIT_LAYOUT_DATASET, DatabaseOperation.CLEAN_INSERT).executeOperation(databaseConnection);

        getMockMvc().perform(
                get(Constants._LAYOUT_URL).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        assertDatasetWithNulls(INIT_LAYOUT_EXPECTED_DATASET, generateBeanValidator());

    }

    @Test
    public void createLayout() throws Exception {

        new SimpleDatasetWithOperation(INIT_LAYOUT_DATASET, DatabaseOperation.CLEAN_INSERT).executeOperation(databaseConnection);

        String layoutReq="{\"name\":\"test4\",\"schema\":\"<div35/>\", \"userId\":\"1\"}";
        getMockMvc().perform(
                post(Constants._LAYOUT_URL).contentType(MediaType.APPLICATION_JSON).content(layoutReq))
                .andExpect(status().isCreated()).andReturn();

        assertDatasetWithNulls(EXPECTED_CREATED_LAYOUT_DATASET, generateBeanValidator());
    }

    private List<AbstractTableValidatorBean> generateBeanValidator() {
        List<AbstractTableValidatorBean> tablesBeans = new ArrayList<AbstractTableValidatorBean>(0);
        String[] layout = { "id", "uuid"};
        String[] user = { "id", "uuid"};
        tablesBeans.add(new AbstractTableValidatorBean("layout", layout));
        tablesBeans.add(new AbstractTableValidatorBean("user", user));

        return tablesBeans;
    }

}
