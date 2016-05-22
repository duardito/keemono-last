package com.keemono.integration.layout;

import com.keemono.base.AbstractBaseITCase;
import com.keemono.base.AbstractTableValidatorBean;
import com.keemono.base.SimpleDatasetWithOperation;
import com.keemono.common.Constants;
import com.keemono.common.converter.request.layout.LayoutExtendedContentBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by edu on 17/10/2015.
 */
public class BasicLayoutsTest extends AbstractBaseITCase {

    private static final String EXPECTED_CREATED_LAYOUT_DATASET = "dataset/layout/expected/created-layout-expected.xml";
    private static final String INIT_LAYOUT_DATASET = "dataset/layout/basic-layout.xml";
    private static final String INIT_LAYOUT_EXPECTED_DATASET = "dataset/layout/expected/basic-layout-expected.xml";
    private static final String EXPECTED_UPDATED_LAYOUT_DATASET = "dataset/layout/expected/updated-layout-expected.xml";
    private static final String EXPECTED_UPDATED_LAYOUT_WITH_USER_DATASET = "dataset/layout/expected/updated-layout-with-user-expected.xml";

    @Test
    public void getAllLayouts() throws Exception {

        new SimpleDatasetWithOperation(INIT_LAYOUT_DATASET, DatabaseOperation.CLEAN_INSERT).executeOperation(databaseConnection);

        getMockMvc().perform(
                get(Constants._LAYOUT_URL + Constants._LIST).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        assertDatasetWithNulls(INIT_LAYOUT_EXPECTED_DATASET, generateBeanValidator());
    }

    @Test
    public void createLayout() throws Exception {

        new SimpleDatasetWithOperation(INIT_LAYOUT_DATASET, DatabaseOperation.CLEAN_INSERT).executeOperation(databaseConnection);

        String layoutReq = LayoutExtendedContentBuilder.aLayout()
                .withCreator("user:1695b78b-7218-4e53-897b-51d29c250965")
                .withName("test4")
                .withSchema("<div35/>")
                .build();

        getMockMvc().perform(
                post(Constants._LAYOUT_URL).contentType(MediaType.APPLICATION_JSON).content(layoutReq))
                .andExpect(status().isCreated()).andReturn();

        assertDatasetWithNulls(EXPECTED_CREATED_LAYOUT_DATASET, generateBeanValidator());
    }

    @Test
    public void updateLayout() throws Exception {
        new SimpleDatasetWithOperation(INIT_LAYOUT_DATASET, DatabaseOperation.CLEAN_INSERT).executeOperation(databaseConnection);

        String layoutReq = LayoutExtendedContentBuilder.aLayout()
                .withName("testupdated")
                .withSchema("divupdated")
                .build();

        getMockMvc().perform(
                put(Constants._LAYOUT_URL + "/{uuid}", "layout:5695b78b-7218-4e53-897b-51d29c250933").contentType(MediaType.APPLICATION_JSON).content(layoutReq))
                .andExpect(status().isOk()).andReturn();

        assertDatasetWithNulls(EXPECTED_UPDATED_LAYOUT_DATASET, generateBeanValidator());
    }

    @Test
    public void updateLayoutWithUSer() throws Exception {
        new SimpleDatasetWithOperation(INIT_LAYOUT_DATASET, DatabaseOperation.CLEAN_INSERT).executeOperation(databaseConnection);

        String layoutReq = LayoutExtendedContentBuilder.aLayout()
                .withCreator("user:1695b78b-7218-4e53-897b-51d29c250965")
                .withName("testupdated")
                .withSchema("divupdated")
                .build();

        getMockMvc().perform(
                put(Constants._LAYOUT_URL + "/{uuid}", "layout:5695b78b-7218-4e53-897b-51d29c250933").contentType(MediaType.APPLICATION_JSON).content(layoutReq))
                .andExpect(status().isOk()).andReturn();

        assertDatasetWithNulls(EXPECTED_UPDATED_LAYOUT_WITH_USER_DATASET, generateBeanValidator());
    }

    private List<AbstractTableValidatorBean> generateBeanValidator() {
        List<AbstractTableValidatorBean> tablesBeans = new ArrayList<AbstractTableValidatorBean>(0);
        String[] layout = {"id", "uuid"};
        String[] user = {"id", "uuid" , "lastPasswordReset", "authorities", "username" , "password"};
        tablesBeans.add(new AbstractTableValidatorBean("layout", layout));
        tablesBeans.add(new AbstractTableValidatorBean("user", user));

        /*
        Expected :[email, lastName, name]
Actual   :[authorities, email, lastname, name, password, username]
         */

        return tablesBeans;
    }

}
