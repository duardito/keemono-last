package com.keemono.layout;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.keemono.base.AbstractBaseITCase;
import com.keemono.utils.Constants;
import org.junit.After;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by edu on 17/10/2015.
 */
public class GetBasicLayoutsTest extends AbstractBaseITCase {

    @After
    public void delete(){}

    @Test
    @DatabaseSetup(value = "classpath:dataset/layout/basic-layout.xml",type = DatabaseOperation.CLEAN_INSERT)
    @ExpectedDatabase(value="classpath:dataset/layout/basic-layout-expected.xml",assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void initTest() throws Exception {

        MvcResult result =getMockMvc().perform(
                get(Constants._LAYOUT_URL).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    @DatabaseSetup(value = "classpath:dataset/layout/basic-layout.xml",type = DatabaseOperation.CLEAN_INSERT)
    @ExpectedDatabase(value = "classpath:dataset/layout/created-layout-expected.xml",assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void createLayout() throws Exception {

        String layoutReq="{\"name\":\"test4\",\"values\":\"<div35/>\"}";
        getMockMvc().perform(
                post(Constants._LAYOUT_URL).contentType(MediaType.APPLICATION_JSON).content(layoutReq))
                .andExpect(status().isCreated()).andReturn();

    }

}
