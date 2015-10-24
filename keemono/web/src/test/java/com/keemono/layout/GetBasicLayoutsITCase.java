package com.keemono.layout;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.keemono.base.AbstractBaseITCase;
import com.keemono.common.converter.dto.layout.LayoutDto;
import com.keemono.service.layout.ILayoutService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by edu on 17/10/2015.
 */
public class GetBasicLayoutsITCase extends AbstractBaseITCase {

    @Autowired
    private ILayoutService layoutService;

    @After
    public void delete(){}

    @Test
    @DatabaseSetup(value = "classpath:dataset/sampleData.xml",type = DatabaseOperation.INSERT)
    @ExpectedDatabase("classpath:dataset/expectedData.xml")
    public void initTest() {
        List<LayoutDto> lista = layoutService.getAllLayoutList();
        lista.stream().forEach(p -> System.out.printf("el dto es :" + p));
        Assert.assertEquals(3, lista.size());
    }

    @Test
    @DatabaseSetup(value = "classpath:dataset/sampleData.xml",type = DatabaseOperation.INSERT)
    @ExpectedDatabase("classpath:dataset/expectedData.xml")
    public void initTest2() {
        List<LayoutDto> lista = layoutService.getAllLayoutList();
        lista.stream().forEach(p -> System.out.printf("el dto es :" + p));
        Assert.assertEquals(3, lista.size());
    }

}
